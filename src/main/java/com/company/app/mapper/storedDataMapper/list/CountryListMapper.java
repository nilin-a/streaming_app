package com.company.app.mapper.storedDataMapper.list;

import com.company.app.dto.storedDataDTO.CountryDTO;
import com.company.app.mapper.storedDataMapper.CountryMapper;
import com.company.app.model.storedDataModel.Country;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring", uses = CountryMapper.class)
public interface CountryListMapper {
    List<Country> toEntityList(List<CountryDTO> countryDTOList);
    List<CountryDTO> toDTOList(List<Country> countryList);
}
