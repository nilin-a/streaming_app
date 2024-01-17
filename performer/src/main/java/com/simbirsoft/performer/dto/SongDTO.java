package com.simbirsoft.performer.dto;

import com.simbirsoft.performer.dto.storedDataDTO.GenreDTO;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
public class SongDTO {
    private long id;
    private String title;
    private Long durationInSeconds;
    private String lyrics;
    private LocalDate releaseDate;
    //private AlbumDTO album;
    private List<PerformerDTO> performers;
    private GenreDTO genre;
}
