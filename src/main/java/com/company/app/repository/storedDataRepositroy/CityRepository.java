package com.company.app.repository.storedDataRepositroy;

import com.company.app.model.storedDataModel.City;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CityRepository extends JpaRepository<City, Long> {
}
