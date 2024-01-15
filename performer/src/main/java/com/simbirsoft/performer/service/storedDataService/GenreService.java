package com.simbirsoft.performer.service.storedDataService;

import com.simbirsoft.performer.dto.storedDataDTO.GenreDTO;
import com.simbirsoft.performer.mapper.storedDataMapper.GenreMapper;
import com.simbirsoft.performer.mapper.storedDataMapper.list.GenreListMapper;
import com.simbirsoft.performer.model.Performer;
import com.simbirsoft.performer.model.storedDataModel.Genre;
import com.simbirsoft.performer.repository.PerformerRepository;
import com.simbirsoft.performer.repository.storedDataRepositroy.GenreRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class GenreService {
    private final GenreRepository genreRepository;
    private final PerformerRepository performerRepository;
    private final GenreMapper genreMapper;
    private final GenreListMapper genreListMapper;

    public GenreDTO createGenre(GenreDTO genreDTO) {
        Genre genre = genreRepository.save(genreMapper.toEntity(genreDTO));
        return genreMapper.toDTO(genreRepository.findById(genre.getId()).orElseThrow());
    }

    public GenreDTO findGenre(Long id) {
        return genreMapper.toDTO(genreRepository.findById(id).orElseThrow());
    }
    public List<GenreDTO> findAllGenre() {
        return genreListMapper.toDTOList(genreRepository.findAll());
    }

    public GenreDTO updateGenre(GenreDTO genre) {
        Genre updatedGenre = genreRepository.findById(genre.getId()).orElseThrow();
        updatedGenre.setName(genre.getName());
        genreRepository.save(updatedGenre);
        return genreMapper.toDTO(updatedGenre);
    }

    public GenreDTO deleteGenre(Long id) {
        Genre genre = genreRepository.findById(id).orElseThrow();

        List<Performer> performers = performerRepository.findByGenreId(id);
        for (Performer performer : performers) {
            performer.getGenre().remove(genre);
            performerRepository.save(performer);
        }

        genreRepository.deleteById(id);
        return genreMapper.toDTO(genre);
    }
}
