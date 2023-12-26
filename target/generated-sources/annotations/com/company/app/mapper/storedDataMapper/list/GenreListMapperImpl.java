package com.company.app.mapper.storedDataMapper.list;

import com.company.app.dto.storedDataDTO.GenreDTO;
import com.company.app.mapper.storedDataMapper.GenreMapper;
import com.company.app.model.storedDataModel.Genre;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-12-26T14:47:39+0400",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 21.0.1 (Oracle Corporation)"
)
@Component
public class GenreListMapperImpl implements GenreListMapper {

    @Autowired
    private GenreMapper genreMapper;

    @Override
    public List<Genre> toEntiryList(List<GenreDTO> genreDTOList) {
        if ( genreDTOList == null ) {
            return null;
        }

        List<Genre> list = new ArrayList<Genre>( genreDTOList.size() );
        for ( GenreDTO genreDTO : genreDTOList ) {
            list.add( genreMapper.toEntity( genreDTO ) );
        }

        return list;
    }

    @Override
    public List<GenreDTO> toDTOList(List<Genre> genreList) {
        if ( genreList == null ) {
            return null;
        }

        List<GenreDTO> list = new ArrayList<GenreDTO>( genreList.size() );
        for ( Genre genre : genreList ) {
            list.add( genreMapper.toDTO( genre ) );
        }

        return list;
    }
}
