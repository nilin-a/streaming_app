package com.simbirsoft.performer.dto;

import com.simbirsoft.performer.dto.storedDataDTO.CityDTO;
import com.simbirsoft.performer.dto.storedDataDTO.GenreDTO;
import lombok.Getter;
import lombok.Setter;

import java.sql.Date;
import java.util.List;

@Getter
@Setter
public class PerformerDTO {
    private long id;
    private String name;
    private String information;
    private CityDTO city;
    private Date birthDate;
    private List<GenreDTO> genre;
}
