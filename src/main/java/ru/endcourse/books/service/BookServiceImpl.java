package ru.endcourse.books.service;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import ru.endcourse.books.model.Author;
import ru.endcourse.books.model.Book;
import ru.endcourse.books.model.Genre;
import ru.endcourse.books.repo.BookRepository;

import java.util.List;
import java.util.UUID;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookRepository bookRepository;
    @Autowired
    private BookService bookService;

    public void addBook(String isbn, String title, String language, Author authorsList, Genre genresList){
        Book book = new Book(isbn, title, language, authorsList, genresList);
        bookRepository.save(book);
    }

    public void updateBook(UUID id, String isbn, String title, String language, Author authorsList, Genre genresList) {
        Book byId = getById(id);
        byId.setIsbn(isbn);
        byId.setTitle(title);
        byId.setLanguage(language);
        byId.setAuthor(authorsList);
        byId.setGenre(genresList);
        bookRepository.save(byId);
    }

    public void deleteBook(UUID id){
        Book byId = getById(id);
        bookRepository.delete(byId);
    }

    public Book getById(UUID id){
        return bookRepository.findById(id)
                .orElseThrow(EntityNotFoundException::new);
    }

    @Override
    public Page<Book> findPaginated(int pageNum, int pageSize) {
        Pageable pageable = PageRequest.of(pageNum - 1, pageSize);
        return this.bookRepository.findAll(pageable);
    }
    @Override
    public Page<Book> findByTitleContainingIgnoreCase(String keyword, int pageNum, int pageSize) {
            Pageable pageable = PageRequest.of(pageNum - 1, pageSize);
            return this.bookRepository.findByTitleContainingIgnoreCase(keyword, pageable);
    }

    @Override
    public Page<Book> findByAuthor_FullnameContainingIgnoreCase(String keyword, int pageNum, int pageSize) {
        Pageable pageable = PageRequest.of(pageNum - 1, pageSize);
        return this.bookRepository.findByAuthor_FullnameContainingIgnoreCase(keyword, pageable);
    }

    @Override
    public Page<Book> findByGenre_GenreContainingIgnoreCase(String keyword, int pageNum, int pageSize) {
        Pageable pageable = PageRequest.of(pageNum - 1, pageSize);
        return this.bookRepository.findByGenre_GenreContainingIgnoreCase(keyword, pageable);
    }
}