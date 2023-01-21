package me.whitedev.chatserver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Iterator;

public class Main {
    static ArrayList<PrintWriter> clientOutputStreams;
    static int PORT;

    public static void main(String[] args) {
        if(args.length > 0){
            PORT = Integer.parseInt(args[0]);
        }else{
            PORT = 8888;
        }
        new Main().runServer();
    }

    public void runServer() {
        clientOutputStreams = new ArrayList<>();
        try {
            ServerSocket serverSocket = new ServerSocket(PORT);
            while (true) {
                Socket clientSocket = serverSocket.accept();
                PrintWriter writer = new PrintWriter(clientSocket.getOutputStream());
                clientOutputStreams.add(writer);

                Thread thread = new Thread(new ClientHandler(clientSocket));
                thread.start();
                System.out.println("[Server] New user connected!");
                Main.sendMessageToUsers("[Server] New user connected!");
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static void sendMessageToUsers(String message) {
        Iterator<PrintWriter> it = clientOutputStreams.iterator();
        while (it.hasNext()) {
            try {
                PrintWriter writer = it.next();
                writer.println(message);
                writer.flush();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }
}

class ClientHandler implements Runnable {
    BufferedReader reader;
    Socket socket;

    public ClientHandler(Socket clientSocket) {
        try {
            socket = clientSocket;
            InputStreamReader isReader = new InputStreamReader(socket.getInputStream());
            reader = new BufferedReader(isReader);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void run() {
        String message;
        try {
            while ((message = reader.readLine()) != null) {
                System.out.println("[Server] New message: " + message);
                Main.sendMessageToUsers(message);
            }
        } catch (Exception ex) {
            Main.sendMessageToUsers("[Server] User disconnected!");
            System.out.println("[Server] User disconnected!");
        }
    }
}
