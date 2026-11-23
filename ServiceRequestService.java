package com.tracko.service;

import com.tracko.entity.ServiceRequest;
import com.tracko.repository.ServiceRequestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceRequestService {

    @Autowired
    private ServiceRequestRepository repository;

    // Get all requests
    public List<ServiceRequest> getAllRequests() {
        return repository.findAll();
    }

    // Save a new or updated request
    public void saveRequest(ServiceRequest request) {
        repository.save(request);
    }

    // Get request by ID
    public ServiceRequest getRequestById(Long id) {
        return repository.findById(id).orElse(null);
    }

    // Delete request
    public void deleteRequest(Long id) {
        repository.deleteById(id);
    }

    // Dashboard counts
    public long getPendingCount() {
        return repository.countByStatus("Pending");
    }

    public long getCompletedCount() {
        return repository.countByStatus("Completed");
    }

    public long getAssignedCount() {
        return repository.countByStatus("Assigned");
    }
}