package com.simbirsoft.performer.service;

import com.simbirsoft.performer.dto.SongDTO;
import com.simbirsoft.performer.mapper.*;
import com.simbirsoft.performer.mapper.storedDataMapper.GenreMapper;
import com.simbirsoft.performer.model.Song;
import com.simbirsoft.performer.repository.SongRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.time.LocalDate;
import java.util.List;

@RequiredArgsConstructor
@Service
public class SongService {
    private final SongRepository songRepository;
    private final SongMapper songMapper;
    private final SongListMapper songListMapper;
    private final PerformerListMapper performerListMapper;
    private final AlbumMapper albumMapper;
    private final GenreMapper genreMapper;

    public SongDTO createSong(SongDTO songDTO) {
        if (songDTO.getReleaseDate() == null) {
            songDTO.setReleaseDate(LocalDate.now());
        }
        Song song = songRepository.save(songMapper.toEntity(songDTO));
        return songMapper.toDTO(songRepository.findById(song.getId()).orElseThrow());
    }

    public SongDTO findSong(Long id) {
        Song song = songRepository.findById(id).orElseThrow();
        return songMapper.toDTO(song);
    }

    public List<SongDTO> findAllSongs() {
        return songListMapper.toDTOList(songRepository.findAll());
    }

    public SongDTO updateSong(SongDTO song) {
        Song updatedSong = songRepository.findById(song.getId()).orElseThrow();
        updatedSong.setTitle(song.getTitle());
        updatedSong.setDurationInSeconds(song.getDurationInSeconds());
        updatedSong.setLyrics(song.getLyrics());
        updatedSong.setReleaseDate(song.getReleaseDate());
        updatedSong.setAlbum(albumMapper.toEntity(song.getAlbum()));
        updatedSong.setPerformers(performerListMapper.toEntityList(song.getPerformers()));
        updatedSong.setGenre(genreMapper.toEntity(song.getGenre()));
        songRepository.save(updatedSong);
        return songMapper.toDTO(updatedSong);
    }

    public SongDTO deleteSong(Long id) {
        SongDTO songDTO = songMapper.toDTO(songRepository.findById(id).orElseThrow());
        songRepository.deleteById(id);
        return songDTO;
    }
}
