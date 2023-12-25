package com.company.app.mapper.storedDataMapper.list;

import com.company.app.dto.storedDataDTO.CityDTO;
import com.company.app.mapper.storedDataMapper.CityMapper;
import com.company.app.model.storedDataModel.City;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring", uses = CityMapper.class)
public interface CityListMapper {
    List<City> toEntityList(List<CityDTO> cityDTOList);
    List<CityDTO> toDTOList(List<City> cityList);
}
