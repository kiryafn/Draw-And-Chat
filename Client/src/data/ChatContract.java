package data;
import java.awt.*;

public interface ChatContract {
    interface View {
        void showMessage(String prefix, Color prexif_color, String sender, Color sender_color, String message, Color message_color);

        void clearInput();

        void addListeners();
    }

    interface Presenter {
        void onSendMessage(Client client, String message);

        void initListeners();

        void drawMessage(String prefix, Color prexif_color, String sender, Color sender_color, String message, Color message_color);
    }

    interface Model {
        void sendMessage(Client client, String message);
    }
}
