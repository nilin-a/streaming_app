package com.simbirsoft.performer.mapper.storedDataMapper.list;

import com.simbirsoft.performer.dto.storedDataDTO.CityDTO;
import com.simbirsoft.performer.mapper.storedDataMapper.CityMapper;
import com.simbirsoft.performer.model.storedDataModel.City;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring", uses = CityMapper.class)
public interface CityListMapper {
    List<City> toEntityList(List<CityDTO> cityDTOList);
    List<CityDTO> toDTOList(List<City> cityList);
}
