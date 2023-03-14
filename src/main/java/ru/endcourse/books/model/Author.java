package ru.endcourse.books.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Entity
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @GenericGenerator(name = "uuid", strategy = "uuid4")
    private UUID id;
    @NotBlank(message = "Фамилия не должно быть пустым")
    private String surname;
    @NotBlank(message = "Имя не должно быть пустым")
    private String name;
    @NotBlank(message = "Отчество не должно быть пустым")
    private String patronymic;
    private String fullname;
    @CreationTimestamp
    private LocalDateTime createDateTime;
    @UpdateTimestamp
    private LocalDateTime changeDateTime;

    public Author() {
    }

    public Author(String surname, String name, String patronymic) {
        this.surname = surname;
        this.name = name;
        this.patronymic = patronymic;
    }
}