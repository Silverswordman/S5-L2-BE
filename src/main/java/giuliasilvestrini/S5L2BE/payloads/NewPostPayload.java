package giuliasilvestrini.S5L2BE.payloads;

import lombok.Getter;

@Getter
public class NewPostPayload {
    private long authorId;
    private String category;
    private String content;
    private int readingTime;
    private String title;

}
