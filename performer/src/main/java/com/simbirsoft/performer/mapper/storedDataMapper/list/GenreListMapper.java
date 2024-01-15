package com.simbirsoft.performer.mapper.storedDataMapper.list;

import com.simbirsoft.performer.dto.storedDataDTO.GenreDTO;
import com.simbirsoft.performer.mapper.storedDataMapper.GenreMapper;
import com.simbirsoft.performer.model.storedDataModel.Genre;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring", uses = GenreMapper.class)
public interface GenreListMapper {
    List<Genre> toEntiryList(List<GenreDTO> genreDTOList);
    List<GenreDTO> toDTOList(List<Genre> genreList);
}
