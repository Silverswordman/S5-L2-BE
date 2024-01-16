package giuliasilvestrini.S5L2BE.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;
import java.time.LocalTime;

@Getter
@Setter

@NoArgsConstructor
public class BlogPost {
    private long id;
    private String category;
    private String title;
    private String content;
    private LocalTime readingTime;
    private String cover;


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
