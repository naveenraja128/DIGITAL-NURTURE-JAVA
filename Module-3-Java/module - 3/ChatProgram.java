import java.io.*;
import java.net.*;

class Server {
    public static void main(String[] args) throws Exception {

        ServerSocket ss = new ServerSocket(5000);

        System.out.println("Waiting for client...");

        Socket s = ss.accept();

        System.out.println("Client Connected");

        BufferedReader br =
            new BufferedReader(
                new InputStreamReader(s.getInputStream())
            );

        String message = br.readLine();

        System.out.println("Client: " + message);

        s.close();
        ss.close();
    }
}

class Client {
    public static void main(String[] args) throws Exception {

        Socket s = new Socket("localhost", 5000);

        PrintWriter pw =
            new PrintWriter(s.getOutputStream(), true);

        pw.println("Hello Server");

        s.close();
    }
}