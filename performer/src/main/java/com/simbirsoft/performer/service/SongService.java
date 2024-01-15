package com.simbirsoft.performer.service;

import com.simbirsoft.performer.dto.SongDTO;
import com.simbirsoft.performer.mapper.PerformerMapper;
import com.simbirsoft.performer.mapper.SongListMapper;
import com.simbirsoft.performer.mapper.SongMapper;
import com.simbirsoft.performer.mapper.storedDataMapper.GenreMapper;
import com.simbirsoft.performer.model.Song;
import com.simbirsoft.performer.repository.SongRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class SongService {
    private final SongRepository songRepository;
    private final SongMapper songMapper;
    private final SongListMapper songListMapper;
    private final PerformerMapper performerMapper;
    private final GenreMapper genreMapper;

    public SongDTO createSong(SongDTO songDTO) {
        Song song = songRepository.save(songMapper.toEntity(songDTO));
        return songMapper.toDTO(songRepository.findById(song.getId()).orElseThrow());
    }

    public SongDTO findSong(Long id) {
        return songMapper.toDTO(songRepository.findById(id).orElseThrow());
    }

    public List<SongDTO> findAllSongs() {
        return songListMapper.toDTOList(songRepository.findAll());
    }

    public SongDTO updateSong(SongDTO song) {
        Song updatedSong = songRepository.findById(song.getId()).orElseThrow();
        updatedSong.setName(song.getName());
        updatedSong.setPerformer(performerMapper.toEntity(song.getPerformer()));
        updatedSong.setGenre(genreMapper.toEntity(song.getGenre()));
        updatedSong.setDuration(song.getDuration());
        songRepository.save(updatedSong);
        return songMapper.toDTO(updatedSong);
    }

    public SongDTO deleteSong(Long id) {
        Song song = songRepository.findById(id).orElseThrow();
        songRepository.deleteById(id);
        return songMapper.toDTO(song);
    }
}
