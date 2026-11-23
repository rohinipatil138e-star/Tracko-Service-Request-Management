package com.tracko.controller;

import com.tracko.entity.Engineer;
import com.tracko.repository.EngineerRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class EngineerController {

    private final EngineerRepository engineerRepository;

    public EngineerController(EngineerRepository engineerRepository) {
        this.engineerRepository = engineerRepository;
    }

    @GetMapping("/engineers")
    public String engineers(Model model) {

        List<Engineer> engineers = engineerRepository.findTop100ByOrderByIdDesc();

        model.addAttribute("engineers", engineers);

        return "engineers";
    }

    @GetMapping("/engineer/{id}")
    public String engineerProfile(@PathVariable Long id, Model model) {

        Engineer engineer = engineerRepository.findById(id).orElseThrow();

        model.addAttribute("engineer", engineer);

        return "engineer-profile";
    }
}