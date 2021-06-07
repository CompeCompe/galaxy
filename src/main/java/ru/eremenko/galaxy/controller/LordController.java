package ru.eremenko.galaxy.controller;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import ru.eremenko.galaxy.model.Lord;
import ru.eremenko.galaxy.service.LordService;

@Controller
public class LordController {

    private final LordService lordService;

    @Autowired
    public LordController(LordService lordService) {
        this.lordService = lordService;
    }

    @GetMapping("/lord")
    public String getPage(Lord lord, Model model) {
        model.addAttribute("lords", lordService.findAll());
        return "lordPage";
    }

    @PostMapping("/createLord")
    public String saveLord(Lord lord) {
        lordService.saveLord(lord);
        return "redirect:/lord";
    }

    @PostMapping("/showAllLords")
    public String showAllLords() {
        return "redirect:/lord";
    }

    @PostMapping("/showYoungerLords")
    public String showYoungerLords(Lord lord, Model model) {
        List<Lord> lordList = lordService.findAll().stream().sorted(Comparator.comparing(Lord::getAge))
                                .limit(10).collect(Collectors.toList());
        model.addAttribute("lords", lordList);
        return "lordPage";
    }

    @PostMapping("/showUnemployedLords")
    public String showUnemployedLords(Lord lord, Model model) {
        model.addAttribute("lords", lordService.findUnemployedLords());
        return "lordPage";
    }

}
