package com.company.app.mapper.storedDataMapper;

import com.company.app.dto.storedDataDTO.CityDTO;
import com.company.app.model.storedDataModel.City;
import javax.annotation.processing.Generated;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-01-12T08:54:06+0400",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 21.0.1 (Oracle Corporation)"
)
@Component
public class CityMapperImpl implements CityMapper {

    @Autowired
    private StateMapper stateMapper;

    @Override
    public City toEntity(CityDTO cityDTO) {
        if ( cityDTO == null ) {
            return null;
        }

        City city = new City();

        city.setId( cityDTO.getId() );
        city.setName( cityDTO.getName() );
        city.setState( stateMapper.toEntity( cityDTO.getState() ) );

        return city;
    }

    @Override
    public CityDTO toDTO(City city) {
        if ( city == null ) {
            return null;
        }

        CityDTO cityDTO = new CityDTO();

        cityDTO.setId( city.getId() );
        cityDTO.setName( city.getName() );
        cityDTO.setState( stateMapper.toDTO( city.getState() ) );

        return cityDTO;
    }
}
