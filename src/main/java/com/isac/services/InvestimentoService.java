package com.isac.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.isac.dto.CountType;
import com.isac.model.Investimento;
import com.isac.repositories.InvestimentoRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class InvestimentoService {
	
	private InvestimentoRepository InvestimentoRepository;
	
	@Transactional(readOnly = true)
	public List<Investimento> getInvestimentos(){
		return InvestimentoRepository.getAllInvestimentoDueDateDesc();
	}
	@Transactional
	public Investimento save(Investimento Investimento) {
		return InvestimentoRepository.saveAndFlush(Investimento);
	}
	@Transactional(readOnly = true)
	public boolean existById(Long id) {
		return InvestimentoRepository.existsById(id);
	}
	@Transactional(readOnly = true)
	public Optional<Investimento> getInvestimentoById(Long id) {
		return InvestimentoRepository.findById(id);
	}
	public void delete(Long id) {
		InvestimentoRepository.deleteById(id); 
	}
	
	public List<CountType> getPercentageGroupByType() {
		return InvestimentoRepository.getPercentageGroupByType();
		
	}
	

}
