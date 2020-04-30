package com.steelbooks.crudapp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.steelbooks.crudapp.entity.Steelbook;
import com.steelbooks.crudapp.repository.SteelbookRepository;

@Service
public class SteelbookServiceImpl implements SteelbookService{

	@Autowired
    private SteelbookRepository steelbookRepository;

    public List<Steelbook> findAll() {
        return steelbookRepository.findAll();
    }

    public Optional<Steelbook> findSteelbook(Long id) {
        return steelbookRepository.findById(id);
    }

    public Steelbook saveSteelbook(Steelbook steelbook) {
        return steelbookRepository.save(steelbook);
    }

    public void deleteSteelbook(Long id) {
        steelbookRepository.deleteById(id);
    }
    

    public Page<Steelbook> getPaginatedSteelbooks(Pageable pageable) {
    	
        return steelbookRepository.findAll(pageable);
    }

	@Override
	public Steelbook findOne(Long id) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
