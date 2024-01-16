package giuliasilvestrini.S5L2BE.service;

import giuliasilvestrini.S5L2BE.entities.BlogPost;
import giuliasilvestrini.S5L2BE.exceptions.NotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

@Service
public class BlogPostService {
    private List<BlogPost> posts = new ArrayList<>();

    public List<BlogPost> getPosts() {
        return this.posts;

    }


    public BlogPost findById(long id) {
        BlogPost found = null;
        for (BlogPost blogPost : this.posts) {
            if (blogPost.getId() == id) {
                found = blogPost;
            }
        }
        if (found == null)
            throw new NotFoundException(id);
        return found;
    }

    public BlogPost save(BlogPost body) {
        //id randomico per ora
        Random random = new Random();
        body.setId(random.nextInt(1, 500));
        //aggiunge alla lista di posts
        this.posts.add(body);
        return body;
    }

    public void findByIdAndDelete(long id) {
        Iterator<BlogPost> iterator = this.posts.iterator();
        while (iterator.hasNext()) {
            BlogPost current = iterator.next();
            if (current.getId() == id) {
                iterator.remove();
            }
        }
    }
}
