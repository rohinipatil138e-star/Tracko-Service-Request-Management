package com.tracko.service;

import com.tracko.entity.Engineer;
import com.tracko.repository.EngineerRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EngineerService {

    private final EngineerRepository repository;

    public EngineerService(EngineerRepository repository) {
        this.repository = repository;
    }

    // Get all engineers
    public List<Engineer> getAllEngineers() {
        return repository.findAll();
    }

    // Save new engineer or update existing engineer
    public Engineer saveEngineer(Engineer engineer) {
        return repository.save(engineer);
    }

    // Get engineer by ID
    public Engineer getEngineerById(Long id) {
        return repository.findById(id).orElse(null);
    }

    // Delete engineer
    public void deleteEngineer(Long id) {
        repository.deleteById(id);
    }
}