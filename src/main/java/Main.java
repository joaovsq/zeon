import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Main {

    public static void main(String[] args) {

        try {
            var server = new ServerSocket(239);


            while (true) {
                Socket socket = server.accept();

                var outputStream = socket.getOutputStream();

            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
