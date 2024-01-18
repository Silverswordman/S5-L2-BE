package giuliasilvestrini.S5L2BE.entities;

import jakarta.persistence.*;

import lombok.*;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Getter
@Setter
@Entity
@ToString

public class BlogPost {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String category;
    private String title;
    private String content;
    private int readingTime;
    private String cover;
    @ManyToOne
    @JoinColumn(name = "author_id")
    private Author author;


}


