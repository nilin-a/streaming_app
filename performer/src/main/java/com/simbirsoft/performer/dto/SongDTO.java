package com.simbirsoft.performer.dto;

import com.simbirsoft.performer.dto.storedDataDTO.GenreDTO;
import lombok.Getter;
import lombok.Setter;

import java.sql.Time;

@Getter
@Setter
public class SongDTO {
    private long id;
    private String name;
    private PerformerDTO performer;
    private GenreDTO genre;
    private Time duration;
}
