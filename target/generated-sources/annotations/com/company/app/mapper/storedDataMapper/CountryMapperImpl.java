package com.company.app.mapper.storedDataMapper;

import com.company.app.dto.storedDataDTO.CountryDTO;
import com.company.app.model.storedDataModel.Country;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-01-17T12:21:09+0400",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 21.0.1 (Oracle Corporation)"
)
@Component
public class CountryMapperImpl implements CountryMapper {

    @Override
    public Country toEntity(CountryDTO countryDTO) {
        if ( countryDTO == null ) {
            return null;
        }

        Country country = new Country();

        country.setId( countryDTO.getId() );
        country.setName( countryDTO.getName() );

        return country;
    }

    @Override
    public CountryDTO toDTO(Country country) {
        if ( country == null ) {
            return null;
        }

        CountryDTO countryDTO = new CountryDTO();

        countryDTO.setId( country.getId() );
        countryDTO.setName( country.getName() );

        return countryDTO;
    }
}
