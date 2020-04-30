package com.steelbooks.crudapp.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.steelbooks.crudapp.entity.Steelbook;


@Repository
public interface SteelbookRepository extends JpaRepository<Steelbook, Long>{

//	Page<Steelbook> getPaginatedSteelbooks(PageRequest pageable);
	
	//List<Steelbook> findByTitle(String title);
	
	//public Steelbook findByTitle(String title);
	
	//Page<Article> findAll(Pageable pageable);

}

