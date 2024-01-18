package com.simbirsoft.performer.controller.thymeleafController;

import com.simbirsoft.performer.dto.PerformerDTO;
import com.simbirsoft.performer.dto.storedDataDTO.GenreDTO;
import com.simbirsoft.performer.service.PerformerService;
import com.simbirsoft.performer.service.storedDataService.CityService;
import com.simbirsoft.performer.service.storedDataService.GenreService;
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

    @GetMapping("/update/{id}")
    public String updateForm(@PathVariable(value = "id") Long performerId, Model model) {
        model.addAttribute("performer", performerService.findPerformer(performerId));
        model.addAttribute("availableCities", cityService.findAllCities());
        model.addAttribute("availableGenres", genreService.findAllGenre());
        return "update-performer";
    }

    @PostMapping("/update")
    public String update(@ModelAttribute("performer") PerformerDTO performerDTO,
                         @RequestParam("selectedCity") Long selectedCity,
                         @RequestParam("selectedGenres") List<Long> selectedGenres) {
        performerDTO.setCity(cityService.findCity(selectedCity));
        List<GenreDTO> selectedGenreList = new ArrayList<>();
        for (Long genreId : selectedGenres) {
            GenreDTO genreDTO = genreService.findGenre(genreId);
            selectedGenreList.add(genreDTO);
        }
        performerDTO.setGenre(selectedGenreList);
        performerService.updatePerformer(performerDTO);
        return "redirect:/thyme/performers";
    }

    @PostMapping("/delete/{id}")
    public String delete(@PathVariable("id") Long performerId) {
        performerService.deletePerformer(performerId);
        return "redirect:/thyme/performers";
    }
}
