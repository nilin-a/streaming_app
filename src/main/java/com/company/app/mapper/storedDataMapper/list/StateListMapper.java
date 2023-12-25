package com.company.app.mapper.storedDataMapper.list;

import com.company.app.dto.storedDataDTO.StateDTO;
import com.company.app.mapper.storedDataMapper.StateMapper;
import com.company.app.model.storedDataModel.State;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring", uses = StateMapper.class)
public interface StateListMapper {
    List<State> toEntityList(List<StateDTO> stateDTOList);
    List<StateDTO> toDTOList(List<State> stateList);
}
