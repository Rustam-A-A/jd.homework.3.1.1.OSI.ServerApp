package socket;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static final int SERVER_PORT = 10001;

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(SERVER_PORT);
        Socket clientSocket = serverSocket.accept();
        System.out.println("New connection accepted");

        InputStream from = clientSocket.getInputStream();
        OutputStream to = clientSocket.getOutputStream();

        PrintWriter out = new PrintWriter(to, true);
        BufferedReader in = new BufferedReader(new InputStreamReader(from));

        System.out.println("New connection accepted");
        final String name = in.readLine();
        out.println(String.format("Hi %s, your port is %d", name, clientSocket.getPort()));
    }
}











//        BufferedReader reader = new BufferedReader(new InputStreamReader(from));
//        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(to));

//        String message = reader.readLine();
//        System.out.println("Server add: " + message);
//        writer.write(message + " received");
//        writer.flush();

//        while ((message = reader.readLine()) != null){
//            System.out.println("Server add: " + message);
//            writer.write(message + " received");
//            writer.flush();
//        }
