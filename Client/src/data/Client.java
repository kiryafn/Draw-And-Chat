package data;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.net.ConnectException;
import java.net.SocketException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * The Client class represents a client that connects to a local server
 * and processes incoming messages in a separate thread.
 */
public class Client {
    private Socket socket;
    private ExecutorService messageListenerExecutor;
    private BufferedReader in;
    private PrintWriter out;
    private final String serverAddress = "127.0.0.1";
    private final int port = 12345;

    /**
     * Initializes a new Client instance, which establishes a connection
     * to the server using the configured server address and port.
     * It sets up input and output streams for communication with the server
     * and starts a separate thread to listen for messages from the server.
     * If an IOException occurs during the setup, it is printed to the stack trace.
     */
    public Client() {
        messageListenerExecutor = Executors.newSingleThreadExecutor();
        try {

            socket = new Socket(serverAddress, port);
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            out = new PrintWriter(socket.getOutputStream(), true);

            messageListenerExecutor.submit(new MessageListener(in,this));

        } catch (UnknownHostException e) {
            System.err.println("The IP address of the host could not be determined");
            messageListenerExecutor.shutdown();
        } catch (ConnectException e) {
            System.err.println("Failed to connect to the server");
            messageListenerExecutor.shutdown();
        } catch (SocketException e) {
            System.err.println("A general socket error occurred");
            messageListenerExecutor.shutdown();
        } catch (IOException e) {
            System.err.println("An I/O error occurred");
            messageListenerExecutor.shutdown();
        }
    }

    /**
     * Closes the connection to the server and releases resources.
     */
    public void disconnect() {
        try {
            if (in != null) in.close();
            if (out != null) out.close();
            if (socket != null) socket.close();
        } catch (IOException e) {
            System.err.println("Error closing connection");
        } finally {
            messageListenerExecutor.shutdownNow();
        }
    }
}