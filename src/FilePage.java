import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Files;


class FilePage extends HttpMonoid {
  Path path;
  File file;

  public FilePage (String pth) {
    this.file = new File(pth);
    this.path = file.toPath();
  }

  public void write (OutputStream os) {
    try { Files.copy(path, os); } catch (Exception e) {}
  }

}
