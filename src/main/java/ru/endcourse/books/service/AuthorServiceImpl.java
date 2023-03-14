package ru.endcourse.books.service;

import jakarta.persistence.EntityNotFoundException;
import org.apache.commons.collections4.IterableUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.endcourse.books.model.Author;
import ru.endcourse.books.repo.AuthorRepository;

import java.util.List;
import java.util.UUID;

@Service
public class AuthorServiceImpl implements AuthorService {
    @Autowired
    private AuthorRepository authorRepository;
    @Autowired
    private AuthorService authorService;

    @Override
    public List<Author> authorsList() {
        return IterableUtils.toList(showAll());
    }

    public Iterable<Author> showAll(){
        return authorRepository.findAll();
    }

    public void updateAuthor(UUID id, String name, String surname, String patronymic){
        Author byId = getById(id);
        byId.setName(name);
        byId.setSurname(surname);
        byId.setPatronymic(patronymic);
        byId.setFullname(surname + ' ' + name + ' ' + patronymic);
        authorRepository.save(byId);
    }

    public void addAuthor(String surname, String name, String patronymic){
        Author author = new Author(surname, name, patronymic);
        if(author.getFullname() == null || author.getFullname().isBlank()){
            author.setFullname(author.getSurname() + ' ' + author.getName() + ' ' + author.getPatronymic());
        }
        authorRepository.save(author);
    }
    public void deleteAuthor(UUID id){
        Author byId = getById(id);
        authorRepository.delete(byId);
    }
    public Author getById(UUID id){
        return authorRepository.findById(id)
                .orElseThrow(EntityNotFoundException::new);
    }
}
