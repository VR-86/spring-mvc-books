package ru.endcourse.books.service;

import org.springframework.data.domain.Page;
import ru.endcourse.books.model.Author;
import ru.endcourse.books.model.Book;
import ru.endcourse.books.model.Genre;

import java.util.UUID;

public interface BookService {
    Page<Book> findPaginated(int pageNum, int pageSize);
    Page<Book> findByTitleContainingIgnoreCase(String keyword, int pageNum, int pageSize);
    Page<Book> findByAuthor_FullnameContainingIgnoreCase(String keyword, int pageNum, int pageSize);
    Page<Book> findByGenre_GenreContainingIgnoreCase(String keyword, int pageNum, int pageSize);
    Book getById(UUID id);
    void addBook(String isbn, String title, String language, Author authorsList, Genre genresList);
    void updateBook(UUID id, String isbn, String title, String language, Author authorsList, Genre genresList);
    void deleteBook(UUID id);
}
