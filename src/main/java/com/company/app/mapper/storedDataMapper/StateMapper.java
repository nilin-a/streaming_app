package com.company.app.mapper.storedDataMapper;

import com.company.app.dto.storedDataDTO.StateDTO;
import com.company.app.mapper.storedDataMapper.list.CityListMapper;
import com.company.app.model.storedDataModel.State;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = CountryMapper.class)
public interface StateMapper {
    State toEntity(StateDTO stateDTO);
    StateDTO toDTO(State state);
}
