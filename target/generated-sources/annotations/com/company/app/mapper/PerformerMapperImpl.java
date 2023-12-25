package com.company.app.mapper;

import com.company.app.dto.PerformerDTO;
import com.company.app.mapper.storedDataMapper.CityMapper;
import com.company.app.mapper.storedDataMapper.list.GenreListMapper;
import com.company.app.model.Performer;
import javax.annotation.processing.Generated;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-12-25T13:42:40+0400",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 21.0.1 (Oracle Corporation)"
)
@Component
public class PerformerMapperImpl implements PerformerMapper {

    @Autowired
    private CityMapper cityMapper;
    @Autowired
    private GenreListMapper genreListMapper;

    @Override
    public Performer toEntity(PerformerDTO performerDTO) {
        if ( performerDTO == null ) {
            return null;
        }

        Performer performer = new Performer();

        performer.setGenre( genreListMapper.toEntiryList( performerDTO.getGenre() ) );
        performer.setId( performerDTO.getId() );
        performer.setName( performerDTO.getName() );
        performer.setInformation( performerDTO.getInformation() );
        performer.setCity( cityMapper.toEntity( performerDTO.getCity() ) );
        performer.setBirthDate( performerDTO.getBirthDate() );

        return performer;
    }

    @Override
    public PerformerDTO toDTO(Performer performer) {
        if ( performer == null ) {
            return null;
        }

        PerformerDTO performerDTO = new PerformerDTO();

        performerDTO.setId( performer.getId() );
        performerDTO.setName( performer.getName() );
        performerDTO.setInformation( performer.getInformation() );
        performerDTO.setCity( cityMapper.toDTO( performer.getCity() ) );
        performerDTO.setBirthDate( performer.getBirthDate() );
        performerDTO.setGenre( genreListMapper.toDTOList( performer.getGenre() ) );

        return performerDTO;
    }
}
