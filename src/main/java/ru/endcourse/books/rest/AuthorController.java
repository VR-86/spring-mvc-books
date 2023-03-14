package ru.endcourse.books.rest;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.endcourse.books.model.Author;
import ru.endcourse.books.service.AuthorService;

import java.util.*;

@Controller
@RequiredArgsConstructor
public class AuthorController {
    @Autowired
    private AuthorService authorService;

    @GetMapping
    public String allAuthors(Model model){
        return "authors";
    }

    @GetMapping("/authors")
    public String showAllAuthors(Model model){
        model.addAttribute("authors", authorService.showAll());
        return "authors";
    }

    @GetMapping("/authors/add")
    public String addAuthor(Model model){
        return "authors-add";
    }

    @PostMapping("/authors/add")
    @ResponseStatus(HttpStatus.CREATED)
    public String addAuthor(@RequestParam String surname,
                          @RequestParam String name,
                          @RequestParam String patronymic,
                          Model model){
        authorService.addAuthor(surname, name, patronymic);
        return "authors-add";
    }

    @GetMapping("/authors/{id}/details")
    public String authorDetail(@PathVariable UUID id, Model model){
        model.addAttribute("authors", getById(id));
        return "authors-details";
    }

    @GetMapping("/authors/{id}/edit")
    public String authorsEdit(@PathVariable UUID id, Model model){
        model.addAttribute("authors", getById(id));
        return "authors-edit";
    }

    @PostMapping("/authors/{id}/edit")
    public String updateAuthor(@PathVariable UUID id,
                             @RequestParam String name,
                             @RequestParam String surname,
                             @RequestParam String patronymic,
                             Model model){
        authorService.updateAuthor(id, name, surname, patronymic);
        return "redirect:/authors";
    }

    @GetMapping("/authors/{id}/remove")
    public String removeAuthor(@PathVariable UUID id){
        authorService.deleteAuthor(id);
        return "redirect:/authors";
    }

    @GetMapping("/authors/{id}")
    public Author getById(@PathVariable UUID id){
        return authorService.getById(id);
    }
}