package com.simbirsoft.performer.mapper;

import com.simbirsoft.performer.dto.SongDTO;
import com.simbirsoft.performer.model.Song;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring", uses = SongMapper.class)
public interface SongListMapper {
    List<Song> toEntityList(List<SongDTO> songDTOList);
    List<SongDTO> toDTOList(List<Song> songList);
}
