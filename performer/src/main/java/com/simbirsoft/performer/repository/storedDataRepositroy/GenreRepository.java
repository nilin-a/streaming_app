package com.simbirsoft.performer.repository.storedDataRepositroy;

import com.simbirsoft.performer.model.storedDataModel.Genre;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GenreRepository extends JpaRepository<Genre, Long> {

}
