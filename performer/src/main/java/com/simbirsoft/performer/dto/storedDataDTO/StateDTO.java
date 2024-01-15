package com.simbirsoft.performer.dto.storedDataDTO;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StateDTO {
    private long id;
    private String name;
    private CountryDTO country;
}
