package lab10.watki;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class App {
    public static void main(String[] args) throws IOException {
        try (ServerSocket srv = new ServerSocket(5813)) {
            System.out.println("Starting on port 5813");
            while (true) {
                Socket s = srv.accept();
                s.setSoTimeout(5000);//5000 ms
                System.out.print("new connection accepted: ");
                System.out.println(s.getInetAddress());
                new Thread(new Server(s)).start();
            }
        }
    }
}
