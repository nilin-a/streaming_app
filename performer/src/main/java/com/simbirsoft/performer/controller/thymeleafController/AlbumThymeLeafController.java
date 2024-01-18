package com.simbirsoft.performer.controller.thymeleafController;

import com.simbirsoft.performer.dto.AlbumDTO;
import com.simbirsoft.performer.dto.PerformerDTO;
import com.simbirsoft.performer.service.AlbumService;
import com.simbirsoft.performer.service.PerformerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Controller
@RequestMapping("/thyme/albums")
public class AlbumThymeLeafController {
    private final AlbumService albumService;
    private final PerformerService performerService;

    @GetMapping
    public String findAll(Model model) {
        model.addAttribute("albums", albumService.findAllAlbums());
        model.addAttribute("newAlbum", new AlbumDTO());
        model.addAttribute("availablePerformers", performerService.findAllPerformers());
        return "album";
    }

    @PostMapping("/create")
    public String create(@ModelAttribute("album") AlbumDTO albumDTO,
                         @RequestParam("selectedPerformers") List<Long> selectedPerformersId) {
        List<PerformerDTO> performerDTOList = new ArrayList<>();
        for (Long performerId : selectedPerformersId) {
            PerformerDTO performerDTO = performerService.findPerformer(performerId);
            performerDTOList.add(performerDTO);
        }
        albumDTO.setPerformers(performerDTOList);
        albumService.createAlbum(albumDTO);
        return "redirect:/thyme/albums";
    }

    @GetMapping("/update/{id}")
    public String updateForm(@PathVariable("id") Long albumId, Model model) {
        model.addAttribute("album", albumService.findAlbum(albumId));
        model.addAttribute("availablePerformers", performerService.findAllPerformers());
        return "update-album";
    }

    @PutMapping("/update")
    public String update(@ModelAttribute("album") AlbumDTO albumDTO,
                         @RequestParam("selectedPerformers") List<Long> selectedPerformersId) {
        List<PerformerDTO> performerDTOList = new ArrayList<>();
        for (Long performerId : selectedPerformersId) {
            PerformerDTO performerDTO = performerService.findPerformer(performerId);
            performerDTOList.add(performerDTO);
        }
        albumDTO.setPerformers(performerDTOList);
        albumService.updateAlbum(albumDTO);
        return "redirect:/thyme/albums";
    }

    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable("id") Long albumId) {
        albumService.deleteAlbum(albumId);
        return "redirect:/thyme/albums";
    }
}
