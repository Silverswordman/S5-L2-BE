package giuliasilvestrini.S5L2BE.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import jakarta.persistence.OneToMany;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity
@ToString


public class Author {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private String surname;
    private String email;
    private LocalDate birthDate;
    private String avatar;
    @OneToMany
    @JoinColumn(name = "author")
    @JsonIgnore
    private List<BlogPost> posts;

    public Author(String name, String surname, String email, LocalDate birthDate
    ) {
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.birthDate = birthDate;


    }



}
