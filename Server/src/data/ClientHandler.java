package data;

import data.exceptions.InvalidUsernameException;
import data.Server;
import domain.ServerUtils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ClientHandler implements Runnable {
    private final Socket clientSocket;
    private final Server server;
    private PrintWriter out;
    private BufferedReader in;
    private String clientName;

    public ClientHandler(Socket socket, Server server) {
        this.clientSocket = socket;
        this.server = server;

        try {
            out = new PrintWriter(this.clientSocket.getOutputStream(), true);
            in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }

    @Override
    public void run() {
        try {

            String clientName = in.readLine();
            ServerUtils.isNameAllowed(clientName);

            String message;
            while ((message = in.readLine()) != null) {


                System.out.println("Received message from " + clientName + ": " + message);
            }

        } catch (IOException e) {
            System.err.println("Connection error with: " + clientName + ": " + e.getMessage());
        } catch (InvalidUsernameException e){
            System.err.println("Invalid username: " + clientName + ": " + e.getMessage());
        } finally {
            disconnect();
        }
    }

    public void disconnect() {
        try {
            if (in != null) in.close();
            if (out != null) out.close();
            if (clientSocket != null) clientSocket.close();
        } catch (IOException e) {
            System.err.println("Error closing connection");
        }
    }
}