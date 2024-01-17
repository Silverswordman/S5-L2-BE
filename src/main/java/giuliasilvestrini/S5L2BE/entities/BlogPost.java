package giuliasilvestrini.S5L2BE.entities;

import jakarta.persistence.*;

import lombok.*;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity

public class BlogPost {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    public BlogPost(String category, String title, String content, int readingTime, String cover) {
        this.category = category;
        this.title = title;
        this.content = content;
        this.readingTime = readingTime;
        this.cover = cover;
    }

    private String category;
    private String title;
    private String content;
    private int readingTime; // ore minuti e secondi?
    private String cover;
    @ManyToOne
    @JoinColumn(name = "autore_id")
    private Author author;

    @Override
    public String toString() {
        return "BlogPost{" +
                "id=" + id +
                ", category='" + category + '\'' +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", readingTime=" + readingTime +
                ", cover='" + cover + '\'' +
                '}';
    }


}


