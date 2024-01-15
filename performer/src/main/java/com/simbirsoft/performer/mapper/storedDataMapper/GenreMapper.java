package com.simbirsoft.performer.mapper.storedDataMapper;

import com.simbirsoft.performer.dto.storedDataDTO.GenreDTO;
import com.simbirsoft.performer.model.storedDataModel.Genre;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface GenreMapper {
    Genre toEntity(GenreDTO genreDTO);
    GenreDTO toDTO(Genre genre);
}
