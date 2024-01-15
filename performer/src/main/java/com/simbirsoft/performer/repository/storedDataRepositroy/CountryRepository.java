package com.simbirsoft.performer.repository.storedDataRepositroy;

import com.simbirsoft.performer.model.storedDataModel.Country;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CountryRepository extends JpaRepository<Country, Long> {
}
