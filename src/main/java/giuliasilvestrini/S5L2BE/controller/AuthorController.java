package giuliasilvestrini.S5L2BE.controller;

import giuliasilvestrini.S5L2BE.entities.Author;
import giuliasilvestrini.S5L2BE.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;


@RestController // collezione di endpoints i metodi di questa classe
@RequestMapping("/authors")
public class AuthorController {
    @Autowired
    private AuthorService authorService;

    @GetMapping("/")
    public String getAuthors() {
        return authorService.getAuthors().toString();

    }

    @GetMapping("/{id}")
    public Author getAuthorsById(@PathVariable long id) {
        return authorService.findById(id);
    }

    @PostMapping("/")
    @ResponseStatus(HttpStatus.CREATED) // Status Code 201
    public Author saveAuthor(@RequestBody Author body) {
        return authorService.save(body);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT) // Status Code 204 (No content)
    public void findByIdAndDelete(@PathVariable long id) {
        this.authorService.findByIdAndDelete(id);
    }
}

