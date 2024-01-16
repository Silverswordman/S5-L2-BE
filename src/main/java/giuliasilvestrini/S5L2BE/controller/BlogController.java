package giuliasilvestrini.S5L2BE.controller;

import giuliasilvestrini.S5L2BE.entities.BlogPost;
import giuliasilvestrini.S5L2BE.service.BlogPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController // collezione di endpoints i metodi di questa classe
@RequestMapping("/posts")
public class BlogController {
    @Autowired
    private BlogPostService blogPostService;

    @GetMapping("/")
    public String getPosts() {
        return blogPostService.getPosts().toString();

    }

    @GetMapping("/{id}")
    public BlogPost getPostsById(@PathVariable long id) {
        return blogPostService.findById(id);
    }

    @PostMapping("/")
    @ResponseStatus(HttpStatus.CREATED) // Status Code 201
    public BlogPost savePost(@RequestBody BlogPost body) {
        return blogPostService.save(body);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT) // Status Code 204 (No content)
    public void findByIdAndDelete(@PathVariable long id) {
        this.blogPostService.findByIdAndDelete(id);
    }
}


