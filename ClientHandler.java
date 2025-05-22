import java.io.*;
import java.net.*;

public class ClientHandler implements Runnable {
    private Socket clientSocket;
    private BufferedReader in;
    private PrintWriter out;
    private String clientName;

    public ClientHandler(Socket socket) {
        this.clientSocket = socket;
        try {
            in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            out = new PrintWriter(clientSocket.getOutputStream(), true);
            
            // First message from client is their name
            this.clientName = in.readLine();
            System.out.println(clientName + " has joined the chat.");
            Server.broadcast(clientName + " has joined the chat.", this);
        } catch (IOException e) {
            System.out.println("Error setting up client handler: " + e.getMessage());
        }
    }

    @Override
    public void run() {
        try {
            String clientMessage;
            while ((clientMessage = in.readLine()) != null) {
                if (clientMessage.equalsIgnoreCase("exit")) {
                    break;
                }
                System.out.println(clientName + ": " + clientMessage);
                Server.broadcast(clientName + ": " + clientMessage, this);
            }
        } catch (IOException e) {
            System.out.println("Error in client handler: " + e.getMessage());
        } finally {
            try {
                Server.broadcast(clientName + " has left the chat.", this);
                Server.removeClient(this);
                clientSocket.close();
            } catch (IOException e) {
                System.out.println("Error closing client socket: " + e.getMessage());
            }
        }
    }
    
    public void sendMessage(String message) {
        out.println(message);
    }
}