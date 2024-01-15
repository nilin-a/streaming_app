package com.simbirsoft.performer.mapper.storedDataMapper;

import com.simbirsoft.performer.dto.storedDataDTO.CountryDTO;
import com.simbirsoft.performer.model.storedDataModel.Country;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CountryMapper {
    Country toEntity(CountryDTO countryDTO);
    CountryDTO toDTO(Country country);
}
