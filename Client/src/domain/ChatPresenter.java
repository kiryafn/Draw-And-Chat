package domain;

import data.ChatContract;
import data.Client;
import data.MessageInfo;

import java.awt.*;

public class ChatPresenter implements ChatContract.Presenter {
    private ChatContract.View chatView;
    private ChatContract.Model chatModel;

    public ChatPresenter(ChatContract.View chatView, ChatContract.Model chatModel){
        this.chatView = chatView;
        this.chatModel = chatModel;
        initListeners();
    }
    @Override
    public void onSendMessage(Client client, String message) {
        chatView.clearInput();
        chatModel.sendMessage(client, message);
    }


    @Override
    public void initListeners() {
        chatView.addListeners();
    }

    @Override
    public void drawMessage(String prefix, Color prexif_color, String sender, Color sender_color, String message, Color message_color) {
        chatView.showMessage(prefix, prexif_color, sender, sender_color, message, message_color);
    }
}
