package com.simbirsoft.performer.repository.storedDataRepositroy;

import com.simbirsoft.performer.model.storedDataModel.City;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CityRepository extends JpaRepository<City, Long> {
}
