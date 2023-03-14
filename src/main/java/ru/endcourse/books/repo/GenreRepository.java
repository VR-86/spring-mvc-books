package ru.endcourse.books.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.endcourse.books.model.Genre;

import java.util.UUID;

@Repository
public interface GenreRepository extends CrudRepository<Genre, UUID> {
}
