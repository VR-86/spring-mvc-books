package ru.endcourse.books.service;

import ru.endcourse.books.model.Author;

import java.util.List;
import java.util.UUID;

public interface AuthorService {
    Iterable<Author> showAll();
    Author getById(UUID id);
    void addAuthor(String surname, String name, String patronymic);
    void updateAuthor(UUID id, String name, String surname, String patronymic);
    void deleteAuthor(UUID id);
    List<Author> authorsList();
}
