package com.company.app.dto.storedDataDTO;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class StateDTO {
    private long id;
    private String name;
    private List<CityDTO> cities; // Используйте тип данных, соответствующий вашему случаю
}
