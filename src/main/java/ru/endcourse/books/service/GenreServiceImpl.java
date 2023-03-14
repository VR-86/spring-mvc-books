package ru.endcourse.books.service;

import jakarta.persistence.EntityNotFoundException;
import org.apache.commons.collections4.IterableUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.endcourse.books.model.Genre;
import ru.endcourse.books.repo.GenreRepository;

import java.util.List;
import java.util.UUID;

@Service
public class GenreServiceImpl implements GenreService {
    @Autowired
    private GenreRepository genreRepository;
    @Autowired
    private GenreService genreService;

    public List<Genre> genreList(){
        return IterableUtils.toList(showAll());
    }

    public Iterable<Genre> showAll(){
        return genreRepository.findAll();
    }

    public void updateGenre(UUID id, String genreName){
        Genre byId = getById(id);
        byId.setGenre(genreName);
        genreRepository.save(byId);
    }

    public void addGenre(String genreName){
        Genre genre = new Genre(genreName);
        genreRepository.save(genre);
    }

    public void deleteGenre(UUID id){
        Genre byId = getById(id);
        genreRepository.delete(byId);
    }

    public Genre getById(UUID id){
        return genreRepository.findById(id)
                .orElseThrow(EntityNotFoundException::new);
    }
}