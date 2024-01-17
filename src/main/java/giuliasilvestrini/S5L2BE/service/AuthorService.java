package giuliasilvestrini.S5L2BE.service;

import giuliasilvestrini.S5L2BE.entities.Author;
import giuliasilvestrini.S5L2BE.entities.BlogPost;
import giuliasilvestrini.S5L2BE.exceptions.NotFoundException;
import giuliasilvestrini.S5L2BE.repositories.AuthorDAO;
import giuliasilvestrini.S5L2BE.repositories.BlogDAO;
import org.hibernate.query.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.awt.print.Pageable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

@Service

public class AuthorService {
    @Autowired
    private AuthorDAO authorDAO;



    public List<Author> getAuthors() {

        return authorDAO.findAll();

    }

    public Author findById(Long id) {
        return authorDAO.findById(id).orElseThrow(() -> new NotFoundException(id));
    }

    public Author save(Author body) {

        return body;
    }

    public void findByIdAndDelete(Long id) {
        Author found = this.findById(id);
        authorDAO.delete(found);
    }

    public Author findByIdAndUpdate(Long id, Author body) {
        Author found = this.findById(id);
        found.setName(body.getName());

        found.setSurname(body.getSurname());
        found.setEmail(body.getEmail());
        found.setPosts(body.getPosts());
        found.setBirthDate(body.getBirthDate());
        return authorDAO.save(found);
    }
}


