import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;


class Server {
  HttpServer server;
  Database   db;

  public Server (int port) throws Exception {
    server = HttpServer.create(new InetSocketAddress(port), 0);
    server.setExecutor(null);
    db = new Database();
  }

  public void Start () {
    server.start();
  }

  public void AddPage (String path, HttpHandler h) {
    server.createContext("/" + path, h);
  }

}
