package com.simbirsoft.performer.controller.thymeleafController;

import com.simbirsoft.performer.dto.storedDataDTO.GenreDTO;
import com.simbirsoft.performer.service.storedDataService.GenreService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/update/{id}")
    public String updateForm(@PathVariable("id") Long genreId, Model model) {
        model.addAttribute("genre", genreService.findGenre(genreId));
        return "update-genre";
    }

    @PutMapping("/update")
    public String update(@ModelAttribute("genre") GenreDTO genreDTO) {
        genreService.updateGenre(genreDTO);
        return "redirect:/thyme/genres";
    }

    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable("id") Long genreId) {
        genreService.deleteGenre(genreId);
        return "redirect:/thyme/genres";
    }
}
