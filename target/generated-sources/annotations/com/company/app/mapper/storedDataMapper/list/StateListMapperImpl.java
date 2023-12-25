package com.company.app.mapper.storedDataMapper.list;

import com.company.app.dto.storedDataDTO.StateDTO;
import com.company.app.mapper.storedDataMapper.StateMapper;
import com.company.app.model.storedDataModel.State;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-12-25T11:37:53+0400",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 21.0.1 (Oracle Corporation)"
)
@Component
public class StateListMapperImpl implements StateListMapper {

    @Autowired
    private StateMapper stateMapper;

    @Override
    public List<State> toEntityList(List<StateDTO> stateDTOList) {
        if ( stateDTOList == null ) {
            return null;
        }

        List<State> list = new ArrayList<State>( stateDTOList.size() );
        for ( StateDTO stateDTO : stateDTOList ) {
            list.add( stateMapper.toEntity( stateDTO ) );
        }

        return list;
    }

    @Override
    public List<StateDTO> toDTOList(List<State> stateList) {
        if ( stateList == null ) {
            return null;
        }

        List<StateDTO> list = new ArrayList<StateDTO>( stateList.size() );
        for ( State state : stateList ) {
            list.add( stateMapper.toDTO( state ) );
        }

        return list;
    }
}
