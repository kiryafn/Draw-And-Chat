package domain;

import data.ChatContract;
import data.Client;
import data.MessageInfo;

public class ChatModel implements ChatContract.Model {
    @Override
    public void sendMessage(Client client, String message) {
        client.sendMessage(message);
    }
}
