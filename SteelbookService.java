package com.steelbooks.crudapp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.steelbooks.crudapp.repository.SteelbookRepository;
import com.steelbooks.crudapp.entity.Steelbook;


public interface SteelbookService {
	
	List<Steelbook> findAll();

    Steelbook findOne(Long id);

    Steelbook saveSteelbook(Steelbook notes);

    void deleteSteelbook(Long id);
    
    Optional<Steelbook> findSteelbook(Long id);

}
