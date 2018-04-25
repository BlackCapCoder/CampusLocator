import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Files;


class FilePage implements HttpHandler {
  Path path;
  File file;

  public FilePage (String pth) {
    this.file = new File(pth);
    this.path = file.toPath();
  }

  @Override
  public void handle(HttpExchange t) throws IOException {
    t.sendResponseHeaders(200, file.length());
    OutputStream os = t.getResponseBody();

    Files.copy(path, os);
    os.flush();
    os.close();
  }
}
