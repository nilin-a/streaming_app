package com.company.app.repository.storedDataRepositroy;

import com.company.app.model.storedDataModel.Country;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CountryRepository extends JpaRepository<Country, Long> {
}
