package com.simbirsoft.performer.mapper;

import com.simbirsoft.performer.dto.AlbumDTO;
import com.simbirsoft.performer.model.Album;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring", uses = AlbumMapper.class)
public interface AlbumListMapper {
    List<Album> toEntityList(List<AlbumDTO> albumDTOList);
    List<AlbumDTO> toDTOList(List<Album> albumList);
}
