package com.simbirsoft.performer.controller.thymeleafController;

import com.simbirsoft.performer.dto.PerformerDTO;
import com.simbirsoft.performer.dto.SongDTO;
import com.simbirsoft.performer.service.AlbumService;
import com.simbirsoft.performer.service.PerformerService;
import com.simbirsoft.performer.service.SongService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Controller
@RequestMapping("/thyme/songs")
public class SongThemeLeafController {
    private final SongService songService;
    private final AlbumService albumService;
    private final PerformerService performerService;

    @GetMapping
    public String findAll(Model model) {
        model.addAttribute("songs", songService.findAllSongs());
        model.addAttribute("newSong", new SongDTO());
        model.addAttribute("availableAlbums", albumService.findAllAlbums());
        model.addAttribute("availablePerformers", performerService.findAllPerformers());
        return "song";
    }

    @PostMapping("/create")
    public String create(@ModelAttribute("song") SongDTO songDTO,
                         @RequestParam("selectedAlbum") Long selectedAlbumId,
                         @RequestParam("selectedPerformers")List<Long> selectedPerformersId) {
        songDTO.setAlbum(albumService.findAlbum(selectedAlbumId));
        List<PerformerDTO> performerDTOList = new ArrayList<>();
        for (Long performerId : selectedPerformersId) {
            PerformerDTO performerDTO = performerService.findPerformer(performerId);
            performerDTOList.add(performerDTO);
        }
        songDTO.setPerformers(performerDTOList);
        songService.createSong(songDTO);
        return "redirect:/thyme/songs";
    }

    @GetMapping("/update/{id}")
    public String updateForm(@PathVariable("id") Long songId, Model model) {
        model.addAttribute("song", songService.findSong(songId));
        model.addAttribute("availableAlbums", albumService.findAllAlbums());
        model.addAttribute("availablePerformers", performerService.findAllPerformers());
        return "update-song";
    }

    @PutMapping("/update")
    public String update(@ModelAttribute("song") SongDTO songDTO,
                         @RequestParam("selectedAlbum") Long selectedAlbumId,
                         @RequestParam("selectedPerformers") List<Long> selectedPerformersId) {
        songDTO.setAlbum(albumService.findAlbum(selectedAlbumId));
        List<PerformerDTO> performerDTOList = new ArrayList<>();
        for (Long performerId : selectedPerformersId) {
            PerformerDTO performerDTO = performerService.findPerformer(performerId);
            performerDTOList.add(performerDTO);
        }
        songDTO.setPerformers(performerDTOList);
        songService.updateSong(songDTO);
        return "redirect:/thyme/songs";
    }

    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable("id") Long songId) {
        songService.deleteSong(songId);
        return "redirect:/thyme/songs";
    }

}
