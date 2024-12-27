package data;

import domain.ChatService;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Server {
    private String serverIp;
    private int serverPort;
    private static final Map<String, ClientHandler> connectedClients = new ConcurrentHashMap<>();
    private final ExecutorService threadPool = Executors.newCachedThreadPool();

    public ChatService chatService;

    public Server(String configFilePath) {
        loadConfig(configFilePath);
    }

    public void start() {
        try {
            ServerSocket serverSocket = new ServerSocket(serverPort);
            while (true) {
                Socket clientSocket = serverSocket.accept();
                ClientHandler clientHandler = new ClientHandler(clientSocket, this);
                threadPool.execute(clientHandler);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void loadConfig(String configFilePath) {
        Properties properties = new Properties();
        List<String> bannedWords = new ArrayList<>();
        try {
            FileInputStream input = new FileInputStream(configFilePath);
            properties.load(input);
            serverIp = properties.getProperty("server_ip");
            serverPort = Integer.parseInt(properties.getProperty("server_port"));
            bannedWords = Arrays.asList(properties.getProperty("banned_words").split(","));
        } catch (IOException e) {
            System.err.println("Failed to load config file " + configFilePath);
        }

        this.chatService = new ChatService(bannedWords);
    }

    public Map<String, ClientHandler> getConnectedClients() {
        return connectedClients;
    }
}
