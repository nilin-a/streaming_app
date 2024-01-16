package com.company.app.mapper.storedDataMapper.list;

import com.company.app.dto.storedDataDTO.CityDTO;
import com.company.app.mapper.storedDataMapper.CityMapper;
import com.company.app.model.storedDataModel.City;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-01-16T19:37:22+0400",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 21.0.1 (Oracle Corporation)"
)
@Component
public class CityListMapperImpl implements CityListMapper {

    @Autowired
    private CityMapper cityMapper;

    @Override
    public List<City> toEntityList(List<CityDTO> cityDTOList) {
        if ( cityDTOList == null ) {
            return null;
        }

        List<City> list = new ArrayList<City>( cityDTOList.size() );
        for ( CityDTO cityDTO : cityDTOList ) {
            list.add( cityMapper.toEntity( cityDTO ) );
        }

        return list;
    }

    @Override
    public List<CityDTO> toDTOList(List<City> cityList) {
        if ( cityList == null ) {
            return null;
        }

        List<CityDTO> list = new ArrayList<CityDTO>( cityList.size() );
        for ( City city : cityList ) {
            list.add( cityMapper.toDTO( city ) );
        }

        return list;
    }
}
