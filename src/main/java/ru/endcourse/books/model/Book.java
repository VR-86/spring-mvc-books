package ru.endcourse.books.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.validator.constraints.ISBN;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Entity
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @GenericGenerator(name = "uuid", strategy = "uuid4")
    private UUID id;
    @ISBN(message="Неверный формат ISBN")
    @NotBlank(message = "ISBN не должен быть пустым")
    private String isbn;
    @NotBlank(message = "Название книги не должно быть пустым")
    private String title;
    @ManyToOne
    private Author author;
    private String author_fio;
    @ManyToOne
    @Cascade(CascadeType.SAVE_UPDATE)
    private Genre genre;
    private String language;
    private int sold;
    @CreationTimestamp
    private LocalDateTime createDateTime;
    @UpdateTimestamp
    private LocalDateTime changeDateTime;

    public Book(){
    }

    public Book(String isbn, String title, String language, Author author, Genre genre) {
        this.isbn = isbn;
        this.title = title;
        this.language = language;
        this.author = author;
        this.genre = genre;
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }
}
