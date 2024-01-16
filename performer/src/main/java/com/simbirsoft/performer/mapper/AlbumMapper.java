package com.simbirsoft.performer.mapper;

import com.simbirsoft.performer.dto.AlbumDTO;
import com.simbirsoft.performer.model.Album;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {PerformerListMapper.class, SongListMapper.class})
public interface AlbumMapper {
    Album toEntity(AlbumDTO albumDTO);
    AlbumDTO toDTO(Album album);
}
