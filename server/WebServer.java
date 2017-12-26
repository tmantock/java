import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class WebServer {
  protected void start() {
    ServerSocket socket;

    System.out.println("WebServer starting up on PORT: 3000");
    System.out.println("Press Ctrl+C to exit");

    try {
      socket = new ServerSocket(3000);
    } catch (Exception error) {
      System.out.println("Error: " + error);

      return;
    }

    System.out.println("Waiting for a connection");

    while (true) {
      try {
        Socket remote = socket.accept();
        System.out.println("Connection, sending data");
        BufferedReader in = new BufferedReader(new InputStreamReader(remote.getInputStream()));
        PrintWriter out = new PrintWriter(remote.getOutputStream());

        String str = ".";

        while (!str.equals("")) str = in.readLine();

        out.println("HTTP/1.0 200 OK");
        out.println("Content-Type: text/html");
        out.println("Server: Bot");
        out.println("");
        out.println("<h1>Hello, World!</h1>");
        out.flush();
        remote.close();
      } catch (Exception error) {
        System.out.println("Error: " + error);
      }
    }
  }

  public static void main(String args[]) {
    WebServer ws = new WebServer();
    ws.start();
  }
}
