import java.io.*;
import java.net.*;
import java.util.Scanner;

public class Client {
    private static final String SERVER_IP = "localhost";
    private static final int SERVER_PORT = 12345;
    private String clientName;

    public static void main(String[] args) {
        new Client().startClient();
    }

    public void startClient() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter your name: ");
        clientName = scanner.nextLine();
        
        try (Socket socket = new Socket(SERVER_IP, SERVER_PORT);
             PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
             BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
             BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in))) {
            
            // Send client name to server first
            out.println(clientName);
            
            // Start a thread to listen for messages from server
            new Thread(new ServerListener(in)).start();
            
            System.out.println("Connected to chat server. Type 'exit' to quit.");
            String userInput;
            while ((userInput = stdIn.readLine()) != null) {
                if (userInput.equalsIgnoreCase("exit")) {
                    out.println("exit");
                    break;
                }
                out.println(userInput);
            }
        } catch (UnknownHostException e) {
            System.out.println("Unknown host: " + SERVER_IP);
        } catch (IOException e) {
            System.out.println("I/O error: " + e.getMessage());
        } finally {
            scanner.close();
            System.out.println("Disconnected from server.");
        }
    }
    
    private class ServerListener implements Runnable {
        private BufferedReader in;

        public ServerListener(BufferedReader in) {
            this.in = in;
        }

        @Override
        public void run() {
            try {
                String serverMessage;
                while ((serverMessage = in.readLine()) != null) {
                    System.out.println(serverMessage);
                }
            } catch (IOException e) {
                System.out.println("Error reading from server: " + e.getMessage());
            }
        }
    }
}