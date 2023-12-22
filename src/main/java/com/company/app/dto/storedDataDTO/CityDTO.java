package com.company.app.dto.storedDataDTO;

import com.company.app.dto.PerformerDTO;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class CityDTO {
    private long id;
    private String name;
    private String stateName;
    private List<PerformerDTO> performers; // Используйте тип данных, соответствующий вашему случаю
}
