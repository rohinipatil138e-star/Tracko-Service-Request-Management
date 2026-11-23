package com.tracko.controller;

import com.tracko.repository.EngineerRepository;
import com.tracko.repository.ServiceRequestRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    private final EngineerRepository engineerRepository;
    private final ServiceRequestRepository serviceRequestRepository;

    public HomeController(EngineerRepository engineerRepository,
            ServiceRequestRepository serviceRequestRepository) {
        this.engineerRepository = engineerRepository;
        this.serviceRequestRepository = serviceRequestRepository;
    }

    @GetMapping("/")
    public String dashboard(Model model) {

        model.addAttribute("totalEngineers", engineerRepository.count());
        model.addAttribute("activeEngineers", engineerRepository.countByStatus("Active"));

        model.addAttribute("totalRequests", serviceRequestRepository.count());
        model.addAttribute("completedRequests",
                serviceRequestRepository.countByStatus("Completed"));
        model.addAttribute("pendingRequests",
                serviceRequestRepository.countByStatus("Pending"));
        model.addAttribute("assignedRequests",
                serviceRequestRepository.countByStatus("Assigned"));

        model.addAttribute("recentRequests",
                serviceRequestRepository.findTop5ByOrderByIdDesc());

        return "dashboard";
    }
}