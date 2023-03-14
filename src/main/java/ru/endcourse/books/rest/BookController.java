package ru.endcourse.books.rest;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.endcourse.books.model.Author;
import ru.endcourse.books.model.Book;
import ru.endcourse.books.model.Genre;
import ru.endcourse.books.repo.BookRepository;
import ru.endcourse.books.service.AuthorService;
import ru.endcourse.books.service.BookService;
import ru.endcourse.books.service.GenreService;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Controller
@RequiredArgsConstructor
public class BookController {
    @Autowired
    private BookService bookService;
    @Autowired
    private GenreService genreService;
    @Autowired
    private AuthorService authorService;
    private final BookRepository bookRepository;

    @GetMapping(path = {"/books","/search"})
    public String getAll(Model model,
                         @Param("keyword") String keyword,
                         @RequestParam(defaultValue = "1") int pageNum,
                         @RequestParam(defaultValue = "4") int size
                         ) {
        try {
            List<Book> books = new ArrayList<Book>();
            Page<Book> page = null;
            if (keyword == null) {
                page = bookService.findPaginated(pageNum, size);
                page.forEach(books::add);
            } else {
                page = bookService.findByTitleContainingIgnoreCase(keyword, pageNum, size);
                page.forEach(books::add);
                page = bookService.findByAuthor_FullnameContainingIgnoreCase(keyword, pageNum, size);
                page.forEach(books::add);
                page = bookService.findByGenre_GenreContainingIgnoreCase(keyword, pageNum, size);
                page.forEach(books::add);
                model.addAttribute("keyword", keyword);
            }
            model.addAttribute("books", books);
            model.addAttribute("currentPage", pageNum);
            model.addAttribute("totalPages", page.getTotalPages());
            model.addAttribute("totalItems", page.getTotalElements());
        } catch (Exception e) {
            model.addAttribute("message", e.getMessage());
        }
        return "books";
    }

    @GetMapping("/books/add")
    public String booksAdd(Model model){
        model.addAttribute("genres", genreService.genreList());
        model.addAttribute("authors", authorService.authorsList());
        return "books-add";
    }

    @PostMapping("/books/add")
    @ResponseStatus(HttpStatus.CREATED)
    public String addBook(@RequestParam String isbn,
                          @RequestParam String title,
                          @RequestParam String language,
                          @RequestParam Author authorsList,
                          @RequestParam Genre genresList,
                          Model model){
        bookService.addBook(isbn, title, language, authorsList, genresList);
        return "books-add";
    }

    @GetMapping("/books/{id}/details")
    public String bookDetail(@PathVariable UUID id, Model model){
        Book book = getById(id);
        book.setAuthor_fio(book.getAuthor().getFullname());
        model.addAttribute("books", book);
        return "book-details";
    }

    @GetMapping("/books/{id}/edit")
    public String bookEdit(@PathVariable UUID id, Model model){
        model.addAttribute("books", getById(id));
        model.addAttribute("genres", genreService.genreList());
        model.addAttribute("authors", authorService.authorsList());
        return "books-edit";
    }

    @PostMapping("/books/{id}/edit")
    public String updateBook(@PathVariable UUID id,
                             @RequestParam String isbn,
                             @RequestParam String title,
                             @RequestParam String language,
                             @RequestParam Author authorsList,
                             @RequestParam Genre genresList,
                             Model model){
        bookService.updateBook(id, isbn, title, language, authorsList, genresList);
        return "redirect:/books";
    }

    @GetMapping("/books/{id}/remove")
    public String removeBook(@PathVariable UUID id){
        bookService.deleteBook(id);
        return "redirect:/books";
    }

    @GetMapping("/books/{id}")
    public Book getById(@PathVariable UUID id){
        return bookService.getById(id);
    }

    @GetMapping("/books/page/{pageNum}")
    public String findPaginated(@PathVariable (value = "pageNum") int pageNum,
                                Model model) {
        int pageSize = 4;
        Page<Book> page = bookService.findPaginated(pageNum, pageSize);
        List<Book> books = page.getContent();
        model.addAttribute("currentPage", pageNum);
        model.addAttribute("totalPages", page.getTotalPages());
        model.addAttribute("totalItems", page.getTotalElements());
        model.addAttribute("books", books);
        return "books";
    }

}