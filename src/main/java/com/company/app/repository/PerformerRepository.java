package com.company.app.repository;

import com.company.app.model.Performer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PerformerRepository extends JpaRepository<Performer, Long> {
    List<Performer> findByGenreId(Long id);
}
