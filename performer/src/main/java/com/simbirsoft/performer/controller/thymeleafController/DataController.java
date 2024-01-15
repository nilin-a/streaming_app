package com.simbirsoft.performer.controller.thymeleafController;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller()
public class DataController {
    @GetMapping( "/index")
    public String index(Model model) {
        model.addAttribute("smt", "message!");
        return "index";
    }
}
