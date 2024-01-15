package com.simbirsoft.performer.mapper;

import com.simbirsoft.performer.dto.PerformerDTO;
import com.simbirsoft.performer.mapper.storedDataMapper.CityMapper;
import com.simbirsoft.performer.mapper.storedDataMapper.list.GenreListMapper;
import com.simbirsoft.performer.model.Performer;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = {CityMapper.class, GenreListMapper.class})
public interface PerformerMapper {
    @Mapping(target = "genre", source = "performerDTO.genre")
    Performer toEntity(PerformerDTO performerDTO);
    PerformerDTO toDTO(Performer performer);
}
