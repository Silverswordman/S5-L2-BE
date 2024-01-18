package giuliasilvestrini.S5L2BE.payloads;

import lombok.Getter;

import java.time.LocalDate;

@Getter
public class NewAuthorPayload {

    private String name;
    private String surname;
    private String email;
    private String avatar;
private LocalDate birthDate;
}
