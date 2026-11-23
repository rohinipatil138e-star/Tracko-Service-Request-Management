package com.tracko.controller;

import com.tracko.entity.User;
import com.tracko.repository.UserRepository;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
public class LoginController {

    private final UserRepository userRepository;

    public LoginController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping("/login")
    public String loginPage() {
        return "login";
    }

    @PostMapping("/login")
    public String login(@RequestParam String username,
            @RequestParam String password,
            HttpSession session,
            Model model) {

        Optional<User> user = userRepository.findByUsername(username.trim());

        if (user.isPresent() && user.get().getPassword().trim().equals(password.trim())) {
            session.setAttribute("user", user.get());
            return "redirect:/";
        }

        model.addAttribute("error", "Invalid Username or Password");
        return "login";
    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/login";
    }
}