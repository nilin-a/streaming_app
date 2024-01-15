package com.simbirsoft.performer.repository;

import com.simbirsoft.performer.model.Performer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PerformerRepository extends JpaRepository<Performer, Long> {
    List<Performer> findByGenreId(Long id);
}
