package com.simbirsoft.performer.mapper;

import com.simbirsoft.performer.dto.SongDTO;
import com.simbirsoft.performer.mapper.storedDataMapper.GenreMapper;
import com.simbirsoft.performer.model.Song;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = {PerformerMapper.class, GenreMapper.class})
public interface SongMapper {
    Song toEntity(SongDTO songDTO);
    SongDTO toDTO(Song song);
}
