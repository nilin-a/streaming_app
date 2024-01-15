package com.simbirsoft.performer.mapper.storedDataMapper.list;

import com.simbirsoft.performer.dto.storedDataDTO.StateDTO;
import com.simbirsoft.performer.mapper.storedDataMapper.StateMapper;
import com.simbirsoft.performer.model.storedDataModel.State;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring", uses = StateMapper.class)
public interface StateListMapper {
    List<State> toEntityList(List<StateDTO> stateDTOList);
    List<StateDTO> toDTOList(List<State> stateList);
}
