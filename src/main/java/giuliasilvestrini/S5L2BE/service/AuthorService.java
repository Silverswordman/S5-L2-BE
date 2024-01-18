package giuliasilvestrini.S5L2BE.service;

import giuliasilvestrini.S5L2BE.entities.Author;
import giuliasilvestrini.S5L2BE.entities.BlogPost;
import giuliasilvestrini.S5L2BE.exceptions.NotFoundException;
import giuliasilvestrini.S5L2BE.payloads.NewAuthorPayload;
import giuliasilvestrini.S5L2BE.repositories.AuthorDAO;
import giuliasilvestrini.S5L2BE.repositories.BlogDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

@Service

public class AuthorService {
    @Autowired
    private AuthorDAO authorDAO;


    public Page<Author> getAuthors(int page, int size, String sort) {
        Pageable pageable = PageRequest.of(page, size, Sort.by(sort));
        return authorDAO.findAll(pageable);

    }

    public Author findById(Long id) {
        return authorDAO.findById(id).orElseThrow(() -> new NotFoundException(id));
    }

    public Author save(NewAuthorPayload body) {
        Author newAuthor = new Author();
        newAuthor.setName(body.getName());
        newAuthor.setSurname(body.getSurname());
        newAuthor.setEmail(body.getEmail());
        Random random = new Random();
        newAuthor.setBirthDate(LocalDate.of(random.nextInt(1910, 2003), random.nextInt(1, 12), random.nextInt(1, 28)));
        newAuthor.setAvatar("http://picsum.photos/200/200");

        return authorDAO.save(newAuthor);
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


