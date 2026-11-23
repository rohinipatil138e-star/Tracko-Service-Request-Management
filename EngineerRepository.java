package com.tracko.repository;

import com.tracko.entity.Engineer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EngineerRepository extends JpaRepository<Engineer, Long> {

    long countByStatus(String status);

    List<Engineer> findTop100ByOrderByIdDesc();

    List<Engineer> findTop100ByDepartmentContainingIgnoreCaseOrderByIdDesc(String department);

    List<Engineer> findTop100ByNameContainingIgnoreCaseOrderByIdDesc(String name);
}