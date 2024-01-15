package com.simbirsoft.performer.mapper.storedDataMapper;

import com.simbirsoft.performer.dto.storedDataDTO.StateDTO;
import com.simbirsoft.performer.model.storedDataModel.State;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = CountryMapper.class)
public interface StateMapper {
    State toEntity(StateDTO stateDTO);
    StateDTO toDTO(State state);
}
