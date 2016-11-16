package socket.test;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by fuzeqiang(100918) on 2016/10/20 0020.
 */
public class Server {

    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket();
        server.setSoTimeout(1000);
        while (true) {
            Socket socket = server.accept();

        }
    }

}
