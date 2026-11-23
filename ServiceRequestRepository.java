package com.tracko.repository;

import com.tracko.entity.ServiceRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ServiceRequestRepository extends JpaRepository<ServiceRequest, Long> {

    long countByStatus(String status);

    List<ServiceRequest> findTop5ByOrderByIdDesc();
}