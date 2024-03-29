package giuliasilvestrini.S5L2BE.controller;

import giuliasilvestrini.S5L2BE.entities.BlogPost;
import giuliasilvestrini.S5L2BE.payloads.NewPostPayload;
import giuliasilvestrini.S5L2BE.service.BlogPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController // collezione di endpoints i metodi di questa classe
@RequestMapping("/posts")
public class BlogController {
    @Autowired
    private BlogPostService blogPostService;

    @GetMapping("")
    public Page getPosts(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "9") int size, @RequestParam(defaultValue = "title") String sortBy) {
        return blogPostService.getPosts(page, size, sortBy);

    }

    @GetMapping("/{id}")
    public BlogPost getPostsById(@PathVariable long id) {
        return blogPostService.findById(id);
    }

    // LA POST con il nuovo payload
    @PostMapping ("")
    @ResponseStatus(HttpStatus.CREATED) // Status Code 201
    public BlogPost savePost(@RequestBody NewPostPayload body) {
        return blogPostService.save(body);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT) // Status Code 204 (No content)
    public void findByIdAndDelete(@PathVariable long id) {
        this.blogPostService.findByIdAndDelete(id);
    }

    @PutMapping("/{id}")
    public BlogPost getUserByIdAndUpdate(@PathVariable Long id, @RequestBody BlogPost bodymod) {
        return blogPostService.findByIdAndUpdate(id, bodymod);
    }
}


