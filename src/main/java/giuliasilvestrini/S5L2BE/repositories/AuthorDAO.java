package giuliasilvestrini.S5L2BE.repositories;

import giuliasilvestrini.S5L2BE.entities.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorDAO extends JpaRepository<Author, Long> {

}

