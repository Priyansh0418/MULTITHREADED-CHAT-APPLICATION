# MULTITHREADED-CHAT-APPLICATION

*COMPANY*: CODTECH IT SOLUTIONS

*NAME*: PRIYANSH RATHOD

*INTERN ID*: CT04DL651

*DOMAIN*: JAVA

*DURATION*: 4 WEEKS

*MENTOR*:  NEELA SANTHOSH KUMAR 

*DESCRIPTION*:
In this project, I developed a real-time, multi-user chat application using Java Sockets and Multithreading. The application consists of a central server that manages multiple client connections, allowing users to exchange messages in real time. Each client connects to the server, and the server broadcasts messages to all connected clients, simulating a group chat environment.

-Key Features Implemented
Server-Client Architecture:

The server handles incoming client connections and manages message broadcasting.

Clients connect to the server, send messages, and receive messages from other users.

Multithreading for Concurrent Connections:

The server spawns a new thread for each client to handle communication independently.

Ensures that multiple clients can send and receive messages simultaneously without blocking each other.

Real-Time Messaging:

Messages sent by one client are instantly broadcast to all other connected clients.

Users can exit the chat by typing "exit", which closes their connection gracefully.

User Identification:

Each client provides a username upon connecting, allowing others to see who sent a message.

-Tools and Technologies Used
Programming Language: Java (JDK 17 or later)

Development Environment:

VS Code (with Java extensions for coding and debugging)

DeepSeek Chat (for guidance, debugging help, and refining the logic)

Networking Libraries:

java.net.Socket & java.net.ServerSocket (for TCP communication)

java.io.BufferedReader & java.io.PrintWriter (for I/O operations)

Concurrency Handling:

java.lang.Thread (to manage multiple client connections efficiently)

-My Development Process
1. Understanding the Basics
Before coding, I researched:

How Java Sockets work (TCP-based communication).

The role of ServerSocket (waits for client requests) and Socket (establishes a connection).

How multithreading allows handling multiple clients at once.

2. Setting Up the Server
Created Server.java, which:

Listens on a specific port (12345).

Accepts incoming client connections.

For each client, creates a ClientHandler thread.

Maintains a list of active clients using a Set<ClientHandler>.

Implements broadcast() to send messages to all clients except the sender.

3. Developing the Client Handler
Designed ClientHandler.java (a Runnable thread) to:

Read messages from a client using BufferedReader.

Broadcast messages to all other clients via Server.broadcast().

Remove disconnected clients and notify others.

4. Building the Client Application
Developed Client.java, which:

Connects to the server using Socket.

Takes user input via Scanner and sends it to the server.

Runs a separate ServerListener thread to display incoming messages in real time.

5. Testing and Debugging
Ran the server first, then launched multiple client instances (using separate terminal windows).

Verified that:

Messages from one client appeared for all others.

The "exit" command correctly disconnected a user.

Usernames were displayed properly.

Used DeepSeek Chat to troubleshoot issues like:

Socket connection failures.

Thread synchronization problems.

Proper resource cleanup (closing sockets and streams).

6. Future Improvements (Optional Enhancements)
Private Messaging: Allow users to send direct messages.

GUI Interface: Replace the command-line with a JavaFX/Swing UI.

Message History: Store chat logs in a file or database.

Encryption: Secure messages using SSL/TLS.

-Conclusion
This project strengthened my understanding of:
✔ Networking in Java (Sockets, Server-Client models).
✔ Multithreading (handling concurrent users efficiently).
✔ Input/Output Streams (reading/writing data over networks).

By using VS Code for development and DeepSeek Chat for guidance, I successfully built a functional, real-time chat system. This project serves as a foundation for more advanced networked applications, such as online gaming servers or collaborative tools.
