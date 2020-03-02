package com.vomtung.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class IndexController {

    @RequestMapping(value = { "/" })
    public String login(@RequestParam(value = "error", required = false) final String error, final Model model) {

        return "index";
    }
}
