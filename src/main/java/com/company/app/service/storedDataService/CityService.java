package com.company.app.service.storedDataService;

import com.company.app.model.storedDataModel.City;
import com.company.app.repository.storedDataRepositroy.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CityService {
    @Autowired
    private CityRepository cityRepository;
    @Autowired
    private StateService stateService;

    public City createCity(Long stateId, City city) {
        city.setState(stateService.findState(stateId));
        return cityRepository.save(city);
    }

    public City findCity(Long id) {
        return cityRepository.findById(id).orElseThrow();
    }

    public List<City> findAllCities() {
        return cityRepository.findAll();
    }

    public City updateCity(City city) {
        City updatedCity = cityRepository.findById(city.getId()).orElseThrow();
        updatedCity.setName(city.getName());
        return cityRepository.save(updatedCity);
    }

    public void deleteCity(long id) {
        cityRepository.deleteById(id);
    }

}
