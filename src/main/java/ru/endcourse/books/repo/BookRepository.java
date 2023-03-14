package ru.endcourse.books.repo;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import ru.endcourse.books.model.Book;

import java.util.UUID;

@Repository
public interface BookRepository extends CrudRepository<Book, UUID>, PagingAndSortingRepository<Book, UUID> {
    Page<Book> findByTitleContainingIgnoreCase(String keyword, Pageable pageable);
    Page<Book> findByAuthor_FullnameContainingIgnoreCase(String keyword, Pageable pageable);
    Page<Book> findByGenre_GenreContainingIgnoreCase(String keyword, Pageable pageable);
}
