package giuliasilvestrini.S5L2BE.repositories;

import giuliasilvestrini.S5L2BE.entities.Author;
import giuliasilvestrini.S5L2BE.entities.BlogPost;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BlogDAO extends JpaRepository<BlogPost, Long> {
    List<BlogPost> findByAuthor(Author author);
}