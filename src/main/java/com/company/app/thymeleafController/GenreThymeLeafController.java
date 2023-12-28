package com.company.app.thymeleafController;

import com.company.app.service.storedDataService.GenreService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequiredArgsConstructor
@Controller
@RequestMapping("/thyme/genres")
public class GenreThymeLeafController {
    private final GenreService genreService;

    @GetMapping
    public String findAll(Model model) {
        model.addAttribute("genres", genreService.findAllGenre());
        return "genre";
    }
}
