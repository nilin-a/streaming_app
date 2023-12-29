package com.company.app.controller.thymeleafController;

import com.company.app.dto.storedDataDTO.GenreDTO;
import com.company.app.service.storedDataService.GenreService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequiredArgsConstructor
@Controller
@RequestMapping("/thyme/genres")
public class GenreThymeLeafController {
    private final GenreService genreService;

    @GetMapping
    public String findAll(Model model) {
        model.addAttribute("genres", genreService.findAllGenre());
        model.addAttribute("newGenre", new GenreDTO());
        return "genre";
    }

    @PostMapping("/create")
    public String create(@ModelAttribute("genre") GenreDTO genreDTO) {
        genreService.createGenre(genreDTO);
        return "redirect:/thyme/genres";
    }
}
