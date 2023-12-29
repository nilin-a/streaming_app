package com.company.app.controller.thymeleafController;

import com.company.app.dto.PerformerDTO;
import com.company.app.dto.storedDataDTO.CityDTO;
import com.company.app.dto.storedDataDTO.GenreDTO;
import com.company.app.model.Performer;
import com.company.app.service.PerformerService;
import com.company.app.service.storedDataService.CityService;
import com.company.app.service.storedDataService.GenreService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Controller
@RequestMapping("/thyme/performers")
public class PerformerThymeLeafController {
    private final PerformerService performerService;
    private final CityService cityService;
    private final GenreService genreService;

    @GetMapping
    public String findAll(Model model) {
        model.addAttribute("performers", performerService.findAllPerformers());
        model.addAttribute("newPerformer", new PerformerDTO());
        model.addAttribute("availableCities", cityService.findAllCities());
        model.addAttribute("availableGenres", genreService.findAllGenre());
        return "performer";
    }

    @PostMapping("/create")
    public String create(@ModelAttribute("performer") PerformerDTO performerDTO,
                         @RequestParam("selectedCity") Long selectedCity,
                         @RequestParam("selectedGenres") List<Long> selectedGenres) {
        performerDTO.setCity(cityService.findCity(selectedCity));
        List<GenreDTO> selectedGenreList = new ArrayList<>();
        for (Long genreId : selectedGenres) {
            GenreDTO genreDTO = genreService.findGenre(genreId);
            selectedGenreList.add(genreDTO);
        }
        performerDTO.setGenre(selectedGenreList);
        performerService.createPerformer(performerDTO);
        return "redirect:/thyme/performers";
    }
}
