package com.company.app.dto.storedDataDTO;

import com.company.app.dto.PerformerDTO;
import com.company.app.model.storedDataModel.State;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class CityDTO {
    private long id;
    private String name;
    private StateDTO state;
    //private List<PerformerDTO> performers;
}
