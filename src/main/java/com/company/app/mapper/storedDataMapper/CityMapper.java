package com.company.app.mapper.storedDataMapper;

import com.company.app.dto.storedDataDTO.CityDTO;
import com.company.app.model.storedDataModel.City;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = StateMapper.class)
public interface CityMapper {
    City toEntity(CityDTO cityDTO);
    CityDTO toDTO(City city);
}
