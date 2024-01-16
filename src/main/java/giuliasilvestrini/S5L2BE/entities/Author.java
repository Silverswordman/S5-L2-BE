package giuliasilvestrini.S5L2BE.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class Author {
    private long id;
    private String name;
    private String surname;
    private String email;
    private LocalDate birthDate;

}
