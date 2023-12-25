package com.company.app.service.storedDataService;

import com.company.app.dto.storedDataDTO.CityDTO;
import com.company.app.mapper.storedDataMapper.CityMapper;
import com.company.app.mapper.storedDataMapper.StateMapper;
import com.company.app.mapper.storedDataMapper.list.CityListMapper;
import com.company.app.model.storedDataModel.City;
import com.company.app.repository.storedDataRepositroy.CityRepository;
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
