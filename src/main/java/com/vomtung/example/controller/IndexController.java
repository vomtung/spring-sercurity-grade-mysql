package com.vomtung.example.controller;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.security.Principal;

@Controller
public class IndexController {

    @RequestMapping(value = { "/" })
    public String login(@RequestParam(value = "error", required = false) final String error, final Model model) {

        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (principal == null) {
            return "index";
        }

        String username = null;
        if (principal instanceof UserDetails) {
            username = ((UserDetails)principal).getUsername();
        }
        model.addAttribute("username", username);
        return "index";
    }
}
