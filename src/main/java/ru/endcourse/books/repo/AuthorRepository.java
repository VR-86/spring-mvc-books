package ru.endcourse.books.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import ru.endcourse.books.model.Author;

import java.util.UUID;

@Repository
public interface AuthorRepository extends CrudRepository<Author, UUID>, PagingAndSortingRepository<Author, UUID> {
}

