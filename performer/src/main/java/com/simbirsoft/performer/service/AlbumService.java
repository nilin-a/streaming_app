package com.simbirsoft.performer.service;

import com.simbirsoft.performer.dto.AlbumDTO;
import com.simbirsoft.performer.mapper.AlbumListMapper;
import com.simbirsoft.performer.mapper.AlbumMapper;
import com.simbirsoft.performer.mapper.PerformerListMapper;
import com.simbirsoft.performer.mapper.SongListMapper;
import com.simbirsoft.performer.model.Album;
import com.simbirsoft.performer.repository.AlbumRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@RequiredArgsConstructor
@Service
public class AlbumService {
    private final AlbumRepository albumRepository;
    private final AlbumMapper albumMapper;
    private final AlbumListMapper albumListMapper;
    private final PerformerListMapper performerListMapper;
    private final SongListMapper songListMapper;

    public AlbumDTO createAlbum(AlbumDTO albumDTO) {
        if (albumDTO.getReleaseDate() == null) {
            albumDTO.setReleaseDate(LocalDate.now());
        }
        Album album = albumRepository.save(albumMapper.toEntity(albumDTO));
        return albumMapper.toDTO(albumRepository.findById(album.getId()).orElseThrow());
    }

    public AlbumDTO findAlbum(Long id) {
        return albumMapper.toDTO(albumRepository.findById(id).orElseThrow());
    }

    public List<AlbumDTO> findAllAlbums() {
        return albumListMapper.toDTOList(albumRepository.findAll());
    }

    public AlbumDTO updateAlbum(AlbumDTO albumDTO) {
        Album updatedAlbum = albumRepository.findById(albumDTO.getId()).orElseThrow();
        updatedAlbum.setTitle(albumDTO.getTitle());
        updatedAlbum.setDescription(albumDTO.getDescription());
        updatedAlbum.setReleaseDate(albumDTO.getReleaseDate());
        updatedAlbum.setPerformers(performerListMapper.toEntityList(albumDTO.getPerformers()));
        //updatedAlbum.setSongs(songListMapper.toEntityList(albumDTO.getSongs()));
        albumRepository.save(updatedAlbum);
        return albumMapper.toDTO(albumRepository.findById(albumDTO.getId()).orElseThrow());
    }

    public AlbumDTO deleteAlbum(Long id) {
        AlbumDTO albumDTO = albumMapper.toDTO(albumRepository.findById(id).orElseThrow());
        albumRepository.deleteById(id);
        return albumDTO;
    }
}
