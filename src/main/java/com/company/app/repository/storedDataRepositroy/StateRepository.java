package com.company.app.repository.storedDataRepositroy;

import com.company.app.model.storedDataModel.State;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StateRepository extends JpaRepository<State, Long> {
}
