package domain;

import data.Client;

import java.io.BufferedReader;
import java.io.IOException;

public class MessageListener implements Runnable {

    private final BufferedReader in;
    private final Client client;

    public MessageListener(BufferedReader in, Client client) {
        this.in = in;
        this.client = client;
    }

    @Override
    public void run() {
        String message;
        try {
            while ((message = in.readLine()) != null) {
                System.out.println("From Server: " + message);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            client.disconnect();
        }
    }
}