package data;
import Common.domain.*;
import java.awt.*;

public interface ChatContract {
    interface View {
        void showMessage(String prefix, Color prexif_color, String sender, Color sender_color, String message, Color message_color);

        void clearInput();
    }

    interface Presenter {
        void onClick();
    }

    interface Model {
        void sendMessage(String message);
    }
}
