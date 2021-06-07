package ru.eremenko.galaxy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MainController {

    @GetMapping("/")
    private String hello() {
        return "helloPage";
    }

    @PostMapping("/planets")
    public String getPlanetPage() {
        return "redirect:/planet";
    }

    @PostMapping("/lords")
    public String getLordPage() {
        return "redirect:/lord";
    }

    @PostMapping("/main")
    public String goHome() {
        return "redirect:/";
    }
}
