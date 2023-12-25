package com.company.app.mapper;

import com.company.app.dto.PerformerDTO;
import com.company.app.model.Performer;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring", uses = PerformerMapper.class)
public interface PerformerListMapper {
    List<Performer> toEntityList(List<PerformerDTO> performerDTOList);
    List<PerformerDTO> toDTOList(List<Performer> performerList);
}
