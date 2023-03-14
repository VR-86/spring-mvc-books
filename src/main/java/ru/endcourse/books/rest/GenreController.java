package ru.endcourse.books.rest;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.endcourse.books.model.Genre;
import ru.endcourse.books.service.GenreService;

import java.util.UUID;

@Controller
@RequiredArgsConstructor
public class GenreController {
    @Autowired
    private GenreService genreService;

    @GetMapping("/genres")
    public String showAllGenres(Model model){
        model.addAttribute("genres", genreService.showAll());
        return "genres";
    }

    @GetMapping("/genres/add")
    public String addGenre(Model model){
        return "genres-add";
    }

    @PostMapping("/genres/add")
    @ResponseStatus(HttpStatus.CREATED)
    public String addGenre(@RequestParam String genre){
        genreService.addGenre(genre);
        return "genres-add";
    }

    @GetMapping("/genres/{id}/details")
    public String genreDetail(@PathVariable UUID id, Model model){
        model.addAttribute("genres", getById(id));
        return "genre-details";
    }

    @GetMapping("/genres/{id}/edit")
    public String genreEdit(@PathVariable UUID id, Model model){
        model.addAttribute("genres", getById(id));
        return "genres-edit";
    }

    @PostMapping("/genres/{id}/edit")
    public String updateGenre(@PathVariable UUID id, @RequestParam String genre){
        genreService.updateGenre(id, genre);
        return "redirect:/genres";
    }

    @GetMapping("/genres/{id}/remove")
    public String removeGenre(@PathVariable UUID id){
        genreService.deleteGenre(id);
        return "redirect:/genres";
    }

    @GetMapping("/genres/{id}")
    public Genre getById(@PathVariable UUID id){
        return genreService.getById(id);
    }
}