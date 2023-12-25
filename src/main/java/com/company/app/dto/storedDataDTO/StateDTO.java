package com.company.app.dto.storedDataDTO;

import com.company.app.model.storedDataModel.Country;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class StateDTO {
    private long id;
    private String name;
    private CountryDTO country;
    //private List<CityDTO> cities;
}
