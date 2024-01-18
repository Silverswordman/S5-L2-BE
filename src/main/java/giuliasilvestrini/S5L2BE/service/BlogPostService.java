package giuliasilvestrini.S5L2BE.service;

import giuliasilvestrini.S5L2BE.entities.Author;
import giuliasilvestrini.S5L2BE.entities.BlogPost;
import giuliasilvestrini.S5L2BE.exceptions.NotFoundException;
import giuliasilvestrini.S5L2BE.payloads.NewPostPayload;
import giuliasilvestrini.S5L2BE.repositories.AuthorDAO;
import giuliasilvestrini.S5L2BE.repositories.BlogDAO;
import org.hibernate.query.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

@Service
public class BlogPostService {

    @Autowired
    private BlogDAO blogDAO;
    @Autowired
    private AuthorService authorService;

    public List<BlogPost> getPosts() {

        return blogDAO.findAll();

    }


    public BlogPost findById(Long id) {
        return blogDAO.findById(id).orElseThrow(() -> new NotFoundException(id));
    }

    public BlogPost save(NewPostPayload body) {
        Author author = authorService.findById(body.getAuthorId());
        BlogPost newBlogPost = new BlogPost();
        newBlogPost.setTitle(body.getTitle());
        newBlogPost.setContent(body.getContent());
        newBlogPost.setReadingTime(body.getReadingTime());
        newBlogPost.setCover("http://picsum.photos/200/200");
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
