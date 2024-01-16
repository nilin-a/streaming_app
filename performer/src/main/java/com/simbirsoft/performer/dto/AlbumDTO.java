package com.simbirsoft.performer.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
public class AlbumDTO {
    private long id;
    private String title;
    private String description;
    private LocalDate releaseDate;
    private List<PerformerDTO> performers;
    private List<SongDTO> songs;
}
