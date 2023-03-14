package ru.endcourse.books.service;

import ru.endcourse.books.model.Genre;

import java.util.List;
import java.util.UUID;

public interface GenreService {
    Iterable<Genre> showAll();
    Genre getById(UUID id);
    void addGenre(String genreName);
    void updateGenre(UUID id, String genreName);
    void deleteGenre(UUID id);
    List<Genre> genreList();
}
