package domain;

import data.Client;
import data.enums.Pallet;
import data.parser.MessageKey;
import data.parser.MessageParser;

import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.Map;

public class MessageListener implements Runnable {

    private final BufferedReader in;
    private final Client client;

    public MessageListener(BufferedReader in, Client client) {
        this.in = in;
        this.client = client;
    }

    @Override
    public void run() {
        String data;
        try {
            while ((data = in.readLine()) != null) {
                Map<String, String> parsedData = MessageParser.parseMessage(data);

                if(parsedData.get(MessageKey.TYPE.getKey()).equals("chat")){
                    String prefix = parsedData.get(MessageKey.PREFIX.getKey());
                    String sender = parsedData.get(MessageKey.SENDER.getKey());
                    String chatMessage = parsedData.get(MessageKey.MESSAGE.getKey());

                    //chatPresenter.drawMessage(prefix, autoPrefixColor(prefix).value(), sender, Color.BLACK, chatMessage, Color.DARK_GRAY);
                }
                else{
                    //draws the circle from other client
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            client.disconnect();
        }
    }

    public static Pallet autoPrefixColor(String prefix){
        for (Pallet pallet : Pallet.values()) {
            if(pallet.name().equalsIgnoreCase(prefix)){
                return pallet;
            }
        }
        return Pallet.SERVER;
    }
}