package com.company.app.mapper.storedDataMapper.list;

import com.company.app.dto.storedDataDTO.CountryDTO;
import com.company.app.mapper.storedDataMapper.CountryMapper;
import com.company.app.model.storedDataModel.Country;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-01-12T16:52:43+0400",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 21.0.1 (Oracle Corporation)"
)
@Component
public class CountryListMapperImpl implements CountryListMapper {

    @Autowired
    private CountryMapper countryMapper;

    @Override
    public List<Country> toEntityList(List<CountryDTO> countryDTOList) {
        if ( countryDTOList == null ) {
            return null;
        }

        List<Country> list = new ArrayList<Country>( countryDTOList.size() );
        for ( CountryDTO countryDTO : countryDTOList ) {
            list.add( countryMapper.toEntity( countryDTO ) );
        }

        return list;
    }

    @Override
    public List<CountryDTO> toDTOList(List<Country> countryList) {
        if ( countryList == null ) {
            return null;
        }

        List<CountryDTO> list = new ArrayList<CountryDTO>( countryList.size() );
        for ( Country country : countryList ) {
            list.add( countryMapper.toDTO( country ) );
        }

        return list;
    }
}
