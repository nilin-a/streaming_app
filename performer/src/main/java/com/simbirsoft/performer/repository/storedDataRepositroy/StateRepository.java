package com.simbirsoft.performer.repository.storedDataRepositroy;

import com.simbirsoft.performer.model.storedDataModel.State;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StateRepository extends JpaRepository<State, Long> {
}
