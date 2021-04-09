package socket;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static final int SERVER_PORT = 10001;

    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("127.0.0.1", SERVER_PORT);

        InputStream from = socket.getInputStream();
        OutputStream to = socket.getOutputStream();

        BufferedReader reader = new BufferedReader(new InputStreamReader(from));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(to));

        System.out.println("Print the name: \n");
        Scanner scanner = new Scanner(System.in);

        String message = scanner.nextLine();
        writer.write(message);
        writer.newLine();
        writer.flush();
        System.out.println("Server echo: " + reader.readLine());

        scanner.close();
    }
}











//        while (!(message = scanner.nextLine()).isEmpty()){
//            writer.write(message );
//            writer.newLine();
//            writer.flush();
//            System.out.println("Server echo: " + reader.readLine());
//        }
