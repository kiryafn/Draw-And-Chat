package domain;

import java.util.List;

public class ChatService {
    public List<String> banWords;

    public ChatService(List<String> banWords) {
        this.banWords = banWords;
    }
}
