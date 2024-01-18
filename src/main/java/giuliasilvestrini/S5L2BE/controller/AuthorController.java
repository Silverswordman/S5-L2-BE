package giuliasilvestrini.S5L2BE.controller;

import giuliasilvestrini.S5L2BE.entities.Author;
import giuliasilvestrini.S5L2BE.entities.BlogPost;
import giuliasilvestrini.S5L2BE.payloads.NewAuthorPayload;
import giuliasilvestrini.S5L2BE.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;


@RestController // collezione di endpoints i metodi di questa classe
@RequestMapping("/authors")
public class AuthorController {
    @Autowired
    private AuthorService authorService;

    //Get Generale
    @GetMapping("")
    public Page getAuthors(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "9") int size, @RequestParam(defaultValue = "name") String sortBy) {
        return authorService.getAuthors(page, size, sortBy);

    }

    // get per id autore
    @GetMapping("/{id}")
    public Author getAuthorsById(@PathVariable long authorId) {
        return authorService.findById(authorId);
    }

    //salva autore
    @PostMapping("")
    @ResponseStatus(HttpStatus.CREATED) // Status Code 201
    public Author saveAuthor(@RequestBody NewAuthorPayload body) {
        return authorService.save(body);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT) // Status Code 204 (No content)
    public void findByIdAndDelete(@PathVariable long authorId) {
        this.authorService.findByIdAndDelete(authorId);
    }

    @PutMapping("/{id}")
    public Author getUserByIdAndUpdate(@PathVariable Long authorId, @RequestBody Author body) {
        return authorService.findByIdAndUpdate(authorId, body);
    }
}

