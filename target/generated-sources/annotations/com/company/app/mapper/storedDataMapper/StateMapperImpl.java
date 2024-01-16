package com.company.app.mapper.storedDataMapper;

import com.company.app.dto.storedDataDTO.StateDTO;
import com.company.app.model.storedDataModel.State;
import javax.annotation.processing.Generated;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-01-16T19:37:22+0400",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 21.0.1 (Oracle Corporation)"
)
@Component
public class StateMapperImpl implements StateMapper {

    @Autowired
    private CountryMapper countryMapper;

    @Override
    public State toEntity(StateDTO stateDTO) {
        if ( stateDTO == null ) {
            return null;
        }

        State state = new State();

        state.setId( stateDTO.getId() );
        state.setName( stateDTO.getName() );
        state.setCountry( countryMapper.toEntity( stateDTO.getCountry() ) );

        return state;
    }

    @Override
    public StateDTO toDTO(State state) {
        if ( state == null ) {
            return null;
        }

        StateDTO stateDTO = new StateDTO();

        stateDTO.setId( state.getId() );
        stateDTO.setName( state.getName() );
        stateDTO.setCountry( countryMapper.toDTO( state.getCountry() ) );

        return stateDTO;
    }
}
