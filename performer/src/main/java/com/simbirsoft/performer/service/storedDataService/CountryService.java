package com.simbirsoft.performer.service.storedDataService;

import com.simbirsoft.performer.dto.storedDataDTO.CountryDTO;
import com.simbirsoft.performer.mapper.storedDataMapper.CountryMapper;
import com.simbirsoft.performer.mapper.storedDataMapper.list.CountryListMapper;
import com.simbirsoft.performer.model.storedDataModel.Country;
import com.simbirsoft.performer.repository.storedDataRepositroy.CountryRepository;
import lombok.RequiredArgsConstructor;
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
