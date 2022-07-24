package com.isac.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.isac.dto.CountType;
import com.isac.model.Investimento;

public interface InvestimentoRepository extends JpaRepository<Investimento,Long> {

	
	@Query(value="Select * from Investimento order by due_date desc",nativeQuery = true)
	public List<Investimento> getAllInvestimentoDueDateDesc();
	
	
	@Query(value="Select new com.isac.dto.CountType(COUNT(*)/(Select COUNT(*) from Investimento) *100,type) from Investimento GROUP BY type")
	public List<CountType> getPercentageGroupByType();
	
}
