package ru.eremenko.galaxy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import ru.eremenko.galaxy.model.Planet;
import ru.eremenko.galaxy.service.LordService;
import ru.eremenko.galaxy.service.PlanetService;

@Controller
public class PlanetController {
    private final LordService lordService;
    private final PlanetService planetService;

    @Autowired
    public PlanetController(LordService lordService, PlanetService planetService) {
        this.lordService = lordService;
        this.planetService = planetService;
    }

    @GetMapping("/planet")
    public String getPage(Planet planet, Model model) {
        model.addAttribute("lords", lordService.findAll());
        model.addAttribute("planets", planetService.findAll());
        return "planetPage";
    }

    @PostMapping("/createPlanet")
    public String savePlanet(Planet planet) {
        planetService.savePlanet(planet);
        return "redirect:/planet";
    }

    @GetMapping("planet-delete/{id}")
    public String deleteUser(@PathVariable("id") Long id){
        planetService.deleteById(id);
        return "redirect:/planet";
    }

    @GetMapping("/planet-update/{id}")
    public String updateUserForm(@PathVariable("id") Long id, Model model){
        Planet planet = planetService.findById(id);
        model.addAttribute("planet", planet);
        model.addAttribute("lords", lordService.findAll());
        return "planetUpdate";
    }
}
