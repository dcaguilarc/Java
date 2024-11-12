import com.sun.net.httpserver.HttpServer;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpExchange;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;

public class Prueba1 {

    public static void main(String[] args) throws IOException {
        // Crear un servidor HTTP que escuche en el puerto 8082
        HttpServer server = HttpServer.create(new InetSocketAddress(8082), 0);
        server.createContext("/", new MyHandler());
        server.setExecutor(null); // Usa el ejecutor predeterminado
        server.start();
        System.out.println("Servidor HTTP iniciado en http://localhost:8082");
    }

    static class MyHandler implements HttpHandler {
        @Override
        public void handle(HttpExchange exchange) throws IOException {
            String response = "<html><head><title>Servidor Java</title>"
                    + "<style>"
                    + "body { font-family: Arial, sans-serif; background-color: #f0f0f0; color: #333; }"
                    + ".container { display: flex; align-items: center; justify-content: center; height: 100vh; }"
                    + ".content { text-align: center; background: #ffffff; padding: 20px; border-radius: 10px; box-shadow: 0 4px 8px rgba(0, 0, 0, 0.2); }"
                    + "h1 { color: #007bff; }"
                    + "p { font-size: 1.2em; }"
                    + "</style></head>"
                    + "<body><div class='container'><div class='content'>"
                    + "<h1>Bienvenido al Servidor Java</h1>"
                    + "<p>Este es un servidor HTTP simple en Java. La conexión es exitosa.</p>"
                    + "</div></div></body></html>";
            
            exchange.sendResponseHeaders(200, response.length());
            OutputStream os = exchange.getResponseBody();
            os.write(response.getBytes());
            os.close();
        }
    }
}