package giuliasilvestrini.S5L2BE.service;

import giuliasilvestrini.S5L2BE.entities.Author;
import giuliasilvestrini.S5L2BE.entities.BlogPost;
import giuliasilvestrini.S5L2BE.exceptions.NotFoundException;
import giuliasilvestrini.S5L2BE.payloads.NewPostPayload;
import giuliasilvestrini.S5L2BE.repositories.BlogDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;


import java.util.Random;

@Service
public class BlogPostService {

    @Autowired
    private BlogDAO blogDAO;
    @Autowired
    private AuthorService authorService;

    public Page<BlogPost> getPosts(int page, int size, String sort) {
        Pageable pageable = PageRequest.of(page, size, Sort.by(sort));
        return blogDAO.findAll(pageable);

    }


    public BlogPost findById(Long id) {
        return blogDAO.findById(id).orElseThrow(() -> new NotFoundException(id));
    }

    public BlogPost save(NewPostPayload body) {
        // istanzi autori e poi lo chiedi per il json
        Author author = authorService.findById(body.getAuthorId());
        BlogPost newBlogPost = new BlogPost();
        newBlogPost.setTitle(body.getTitle());
        newBlogPost.setContent(body.getContent());
        Random random = new Random();
        newBlogPost.setReadingTime(random.nextInt(1, 51));
        newBlogPost.setCover("http://picsum.photos/200/200");
        // qua chiedi autore
        newBlogPost.setAuthor(author);
        newBlogPost.setCategory(body.getCategory());
        return blogDAO.save(newBlogPost);
    }

    public void findByIdAndDelete(Long id) {
        BlogPost found = this.findById(id);
        blogDAO.delete(found);
    }

    public BlogPost findByIdAndUpdate(Long id, BlogPost body) {
        BlogPost found = this.findById(id);
        found.setCategory(body.getCategory());
        found.setTitle(body.getTitle());
        found.setContent(body.getContent());
        found.setReadingTime(body.getReadingTime());
        found.setCover(body.getCover());
        return blogDAO.save(found);
    }
}
