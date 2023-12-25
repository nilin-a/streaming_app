package com.company.app.mapper.storedDataMapper;

import com.company.app.dto.storedDataDTO.CountryDTO;
import com.company.app.mapper.storedDataMapper.list.StateListMapper;
import com.company.app.model.storedDataModel.Country;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CountryMapper {
    Country toEntity(CountryDTO countryDTO);
    CountryDTO toDTO(Country country);
}
