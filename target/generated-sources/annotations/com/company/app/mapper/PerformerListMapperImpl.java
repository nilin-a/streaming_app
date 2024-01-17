package com.company.app.mapper;

import com.company.app.dto.PerformerDTO;
import com.company.app.model.Performer;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-01-17T12:21:10+0400",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 21.0.1 (Oracle Corporation)"
)
@Component
public class PerformerListMapperImpl implements PerformerListMapper {

    @Autowired
    private PerformerMapper performerMapper;

    @Override
    public List<Performer> toEntityList(List<PerformerDTO> performerDTOList) {
        if ( performerDTOList == null ) {
            return null;
        }

        List<Performer> list = new ArrayList<Performer>( performerDTOList.size() );
        for ( PerformerDTO performerDTO : performerDTOList ) {
            list.add( performerMapper.toEntity( performerDTO ) );
        }

        return list;
    }

    @Override
    public List<PerformerDTO> toDTOList(List<Performer> performerList) {
        if ( performerList == null ) {
            return null;
        }

        List<PerformerDTO> list = new ArrayList<PerformerDTO>( performerList.size() );
        for ( Performer performer : performerList ) {
            list.add( performerMapper.toDTO( performer ) );
        }

        return list;
    }
}
