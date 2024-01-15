package com.simbirsoft.performer.mapper;

import com.simbirsoft.performer.dto.PerformerDTO;
import com.simbirsoft.performer.model.Performer;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring", uses = PerformerMapper.class)
public interface PerformerListMapper {
    List<Performer> toEntityList(List<PerformerDTO> performerDTOList);
    List<PerformerDTO> toDTOList(List<Performer> performerList);
}
