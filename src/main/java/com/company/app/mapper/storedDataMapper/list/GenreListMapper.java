package com.company.app.mapper.storedDataMapper.list;

import com.company.app.dto.storedDataDTO.GenreDTO;
import com.company.app.mapper.storedDataMapper.GenreMapper;
import com.company.app.model.storedDataModel.Genre;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring", uses = GenreMapper.class)
public interface GenreListMapper {
    List<Genre> toEntiryList(List<GenreDTO> genreDTOList);
    List<GenreDTO> toDTOList(List<Genre> genreList);
}
