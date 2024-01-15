package com.simbirsoft.performer.mapper.storedDataMapper;

import com.simbirsoft.performer.dto.storedDataDTO.CityDTO;
import com.simbirsoft.performer.model.storedDataModel.City;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = StateMapper.class)
public interface CityMapper {
    City toEntity(CityDTO cityDTO);
    CityDTO toDTO(City city);
}
