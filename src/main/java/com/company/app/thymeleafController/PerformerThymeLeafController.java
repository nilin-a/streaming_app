package com.company.app.thymeleafController;

import com.company.app.service.PerformerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequiredArgsConstructor
@Controller
@RequestMapping("/thyme/performers")
public class PerformerThymeLeafController {
    private final PerformerService performerService;

    @GetMapping
    public String findAll(Model model) {
        model.addAttribute("performers", performerService.findAllPerformers());
        return "performer";
    }
}
