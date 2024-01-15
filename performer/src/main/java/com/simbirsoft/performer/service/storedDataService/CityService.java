package com.simbirsoft.performer.service.storedDataService;

import com.simbirsoft.performer.dto.storedDataDTO.CityDTO;
import com.simbirsoft.performer.mapper.storedDataMapper.CityMapper;
import com.simbirsoft.performer.mapper.storedDataMapper.StateMapper;
import com.simbirsoft.performer.mapper.storedDataMapper.list.CityListMapper;
import com.simbirsoft.performer.model.storedDataModel.City;
import com.simbirsoft.performer.repository.storedDataRepositroy.CityRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class CityService {
    private final CityRepository cityRepository;
    private final CityMapper cityMapper;
    private final CityListMapper cityListMapper;
    private final StateMapper stateMapper;

    public CityDTO createCity(CityDTO cityDTO) {
        City city = cityRepository.save(cityMapper.toEntity(cityDTO));
        return cityMapper.toDTO(city);
    }

    public CityDTO findCity(Long id) {
        City city = cityRepository.findById(id).orElseThrow();
        return cityMapper.toDTO(city);
    }

    public List<CityDTO> findAllCities() {
        return cityListMapper.toDTOList(cityRepository.findAll());
    }

    public CityDTO updateCity(CityDTO city) {
        City updatedCity = cityRepository.findById(city.getId()).orElseThrow();
        updatedCity.setName(city.getName());
        updatedCity.setState(stateMapper.toEntity(city.getState()));
        cityRepository.save(updatedCity);
        return cityMapper.toDTO(updatedCity);
    }

    public CityDTO deleteCity(long id) {
        City city = cityRepository.findById(id).orElseThrow();
        cityRepository.deleteById(id);
        return cityMapper.toDTO(city);
    }
}
