package com.company.app.thymeleafController;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller("/thyme")
public class DataController {
    @GetMapping(value = "/index")
    public String index(Model model) {
        model.addAttribute("smt", "message!");
        return "index";
    }
}
