package com.simbirsoft.performer.repository;

import com.simbirsoft.performer.model.Song;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SongRepository extends JpaRepository<Song, Long> {
}
