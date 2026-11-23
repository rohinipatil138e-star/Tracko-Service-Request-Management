package com.tracko.controller;

import com.tracko.entity.Engineer;
import com.tracko.entity.ServiceRequest;
import com.tracko.repository.EngineerRepository;
import com.tracko.repository.ServiceRequestRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class ServiceRequestController {

    private final ServiceRequestRepository serviceRequestRepository;
    private final EngineerRepository engineerRepository;

    public ServiceRequestController(ServiceRequestRepository serviceRequestRepository,
            EngineerRepository engineerRepository) {
        this.serviceRequestRepository = serviceRequestRepository;
        this.engineerRepository = engineerRepository;
    }

    @GetMapping("/requests")
    public String requests(Model model) {

        model.addAttribute("requests", serviceRequestRepository.findAll());
        model.addAttribute("request", new ServiceRequest());

        return "requests";
    }

    @PostMapping("/service-requests/save")
    public String saveRequest(@ModelAttribute ServiceRequest request) {

        request.setStatus("Pending");
        serviceRequestRepository.save(request);

        return "redirect:/requests";
    }

    @GetMapping("/assign/{id}")
    public String assignPage(@PathVariable Long id, Model model) {

        ServiceRequest request = serviceRequestRepository.findById(id).orElseThrow();

        String issue = request.getIssue().toLowerCase();
        String department = "";

        if (issue.contains("wifi") || issue.contains("internet") || issue.contains("router")) {
            department = "Network";
        } else if (issue.contains("ac") || issue.contains("air")) {
            department = "HVAC";
        } else if (issue.contains("printer")) {
            department = "Printer";
        } else if (issue.contains("cctv")) {
            department = "CCTV";
        } else if (issue.contains("mobile") || issue.contains("phone")) {
            department = "Mobile";
        } else if (issue.contains("laptop") || issue.contains("desktop") || issue.contains("hardware")) {
            department = "Hardware";
        } else if (issue.contains("electric")) {
            department = "Electrical";
        }

        List<Engineer> engineers;

        if (!department.isEmpty()) {
            engineers = engineerRepository
                    .findTop100ByDepartmentContainingIgnoreCaseOrderByIdDesc(department);
        } else {
            engineers = engineerRepository.findTop100ByOrderByIdDesc();
        }

        model.addAttribute("request", request);
        model.addAttribute("engineers", engineers);

        return "assign-engineer";
    }

    @PostMapping("/assign/{id}")
    public String assignEngineer(@PathVariable Long id,
            @RequestParam Long engineerId) {

        ServiceRequest request = serviceRequestRepository.findById(id).orElseThrow();
        Engineer engineer = engineerRepository.findById(engineerId).orElseThrow();

        request.setEngineer(engineer);
        request.setStatus("Assigned");

        engineer.setAvailability("Busy");

        engineerRepository.save(engineer);
        serviceRequestRepository.save(request);

        return "redirect:/requests";
    }

    @GetMapping("/complete/{id}")
    public String completeRequest(@PathVariable Long id) {

        ServiceRequest request = serviceRequestRepository.findById(id).orElseThrow();

        if (request.getEngineer() != null) {
            Engineer engineer = request.getEngineer();
            engineer.setAvailability("Available");
            engineerRepository.save(engineer);
        }

        request.setStatus("Completed");
        serviceRequestRepository.save(request);

        return "redirect:/requests";
    }
}