package ru.endcourse.books.rest;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ru.endcourse.books.model.Book;
import ru.endcourse.books.repo.BookRepository;

import java.util.ArrayList;
import java.util.List;

@Controller
public class IndexController {
    private final BookRepository bookRepository;
    public IndexController(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @GetMapping("/")
    public String index(Model model){
        List<Book> books = new ArrayList<Book>();
        Pageable firstPageWithFourElements = PageRequest.of(0, 4);
        bookRepository.findAll(firstPageWithFourElements).forEach(books::add);
        model.addAttribute("books", books);
        return "index";
    }
}