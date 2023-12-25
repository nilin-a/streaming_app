package com.company.app.mapper;

import com.company.app.dto.PerformerDTO;
import com.company.app.mapper.storedDataMapper.CityMapper;
import com.company.app.mapper.storedDataMapper.list.GenreListMapper;
import com.company.app.model.Performer;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = {CityMapper.class, GenreListMapper.class})
public interface PerformerMapper {
    @Mapping(target = "genre", source = "performerDTO.genre")
    Performer toEntity(PerformerDTO performerDTO);
    PerformerDTO toDTO(Performer performer);
}
