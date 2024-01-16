package com.simbirsoft.performer.repository;

import com.simbirsoft.performer.model.Album;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlbumRepository extends JpaRepository<Album, Long> {
}
