package com.company.app.service.storedDataService;

import com.company.app.dto.storedDataDTO.CountryDTO;
import com.company.app.mapper.storedDataMapper.CountryMapper;
import com.company.app.mapper.storedDataMapper.list.CountryListMapper;
import com.company.app.model.storedDataModel.Country;
import com.company.app.repository.storedDataRepositroy.CountryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class CountryService {
    private final CountryRepository countryRepository;
    private final CountryMapper countryMapper;
    private final CountryListMapper countryListMapper;

    public CountryDTO createCountry(CountryDTO countryDTO) {
        Country country = countryRepository.save(countryMapper.toEntity(countryDTO));
        return countryMapper.toDTO(countryRepository.findById(country.getId()).orElseThrow());
    }

    public CountryDTO findCountry(Long id) {
        return countryMapper.toDTO(countryRepository.findById(id).orElseThrow());
    }

    public List<CountryDTO> findAllCountries() {
        return countryListMapper.toDTOList(countryRepository.findAll());
    }

    public CountryDTO updateCountry(CountryDTO city) {
        Country updatedCountry= countryRepository.findById(city.getId()).orElseThrow();
        updatedCountry.setName(city.getName());
        countryRepository.save(updatedCountry);
        return countryMapper.toDTO(updatedCountry);
    }

    public CountryDTO deleteCountry(long id) {
        Country country = countryRepository.findById(id).orElseThrow();
        countryRepository.deleteById(id);
        return countryMapper.toDTO(country);
    }
}
