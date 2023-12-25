package com.company.app.mapper.storedDataMapper;

import com.company.app.dto.storedDataDTO.GenreDTO;
import com.company.app.mapper.PerformerListMapper;
import com.company.app.model.storedDataModel.Genre;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface GenreMapper {
    Genre toEntity(GenreDTO genreDTO);
    GenreDTO toDTO(Genre genre);
}
