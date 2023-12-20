package com.company.app.repository.storedDataRepositroy;

import com.company.app.model.storedDataModel.Genre;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GenreRepository extends JpaRepository<Genre, Long> {

}
