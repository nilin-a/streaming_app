package com.company.app.thymeleafController;

import com.company.app.service.storedDataService.StateService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequiredArgsConstructor
@Controller
@RequestMapping("/thyme/states")
public class StateThymeLeafController {
    private final StateService stateService;

    @GetMapping
    public String findAll(Model model) {
        model.addAttribute("states", stateService.findAllStates());
        return "state";
    }
}
