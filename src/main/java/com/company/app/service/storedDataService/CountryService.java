package com.company.app.service.storedDataService;

import com.company.app.model.storedDataModel.Country;
import com.company.app.repository.storedDataRepositroy.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CountryService {
    @Autowired
    private CountryRepository countryRepository;

    public Country createCountry(Country country) {
        return countryRepository.save(country);
    }

    public Country findCountry(Long id) {
        return countryRepository.findById(id).orElseThrow();
    }

    public List<Country> findAllCountries() {
        return countryRepository.findAll();
    }

    public Country updateCountry(Country city) {
        Country updatedCountry= countryRepository.findById(city.getId()).orElseThrow();
        updatedCountry.setName(city.getName());
        return countryRepository.save(updatedCountry);
    }

    public void deleteCountry(long id) {
        countryRepository.deleteById(id);
    }
}
