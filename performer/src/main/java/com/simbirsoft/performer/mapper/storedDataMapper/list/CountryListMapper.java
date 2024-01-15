package com.simbirsoft.performer.mapper.storedDataMapper.list;

import com.simbirsoft.performer.dto.storedDataDTO.CountryDTO;
import com.simbirsoft.performer.mapper.storedDataMapper.CountryMapper;
import com.simbirsoft.performer.model.storedDataModel.Country;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring", uses = CountryMapper.class)
public interface CountryListMapper {
    List<Country> toEntityList(List<CountryDTO> countryDTOList);
    List<CountryDTO> toDTOList(List<Country> countryList);
}
