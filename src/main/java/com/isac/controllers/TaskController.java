package com.isac.controllers;

import java.util.HashMap;
import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.isac.dto.CountType;
import com.isac.model.Investimento;
import com.isac.services.InvestimentoService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/v1")
@CrossOrigin("*")
@AllArgsConstructor
public class InvestimentoController {
	
	private InvestimentoService investimentoservice;
	
	@GetMapping("/investimento/vData/percentcounttype")
	public List<CountType> getPercentageGroupByType(){
		return nvestimentoservice.getPercentageGroupByType();
	}
	
	
	@GetMapping("/investimento")
	public List<Investimento> getInvestimento(){
		return investimentoservice.getInvestimento();
	}
	
	@PostMapping("/investimento")
	public Investimento addInvestimento(@RequestBody Investimento investimento) {
		return taskservice.save(investimento);
	}
	
	@GetMapping("/investimento/{id}")
	public Investimento getById(@PathVariable Long id) {
		return taskservice.getInvestimentoById(id).orElseThrow(()->new EntityNotFoundException("Requested Investimento not found"));
	}
	
	@PutMapping("/investimento/{id}")
	public ResponseEntity<?> addInvestimento(@RequestBody Investimento taskPara,@PathVariable Long id) {
		if(taskservice.existById(id)) {
			Investimento investimento=taskservice.getInvestimentoById(id).orElseThrow(()->new EntityNotFoundException("Requested Investimento not found"));
			investimento.setTitle(taskPara.getTitle());
			investimento.setDueDate(taskPara.getDueDate());
			investimento.setType(taskPara.getType());
			investimento.setDescription(taskPara.getDescription());
			taskservice.save(investimento);
			return ResponseEntity.ok().body(investimento);
		}else {
			HashMap<String, String>message= new HashMap<>();
			message.put("message", id + " investimento not found or matched");
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(message);
		}
	}
	
	@DeleteMapping("/investimento/{id}")
	public ResponseEntity<?> deleteInvestimento(@PathVariable Long id) {
		if(taskservice.existById(id)) {
			taskservice.delete(id);
			HashMap<String, String>message= new HashMap<>();
			message.put("message", id + " investimento removed");
			return ResponseEntity.status(HttpStatus.OK).body(message);
		}else {
			HashMap<String, String>message= new HashMap<>();
			message.put("message", id + " investimento not found or matched");
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(message);
		}
	}
}
