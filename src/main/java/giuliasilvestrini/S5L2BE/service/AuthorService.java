package giuliasilvestrini.S5L2BE.service;

import giuliasilvestrini.S5L2BE.entities.Author;
import giuliasilvestrini.S5L2BE.entities.BlogPost;
import giuliasilvestrini.S5L2BE.exceptions.NotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

@Service

public class AuthorService {


    private List<Author> authors = new ArrayList<>();

    public List<Author> getAuthors() {
        return this.authors;

    }


    public Author findById(long id) {
        Author found = null;
        for (Author author : this.authors) {
            if (author.getId() == id) {
                found = author;
            }
        }
        if (found == null)
            throw new NotFoundException(id);
        return found;
    }

    public Author save(Author body) {
        //id randomico per ora
        Random random = new Random();
        body.setId(random.nextInt(1, 500));
        //aggiunge alla lista di posts
        this.authors.add(body);
        return body;
    }

    public void findByIdAndDelete(long id) {
        Iterator<Author> iterator = this.authors.iterator();
        while (iterator.hasNext()) {
            Author current = iterator.next();
            if (current.getId() == id) {
                iterator.remove();
            }
        }
    }
}


