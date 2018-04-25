import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Files;

import java.io.PrintWriter;
import java.util.ArrayList;


class MobileMain implements HttpHandler {
  ArrayList<Campus> campuses;

  public MobileMain (ArrayList<Campus> cs) {
    campuses = cs;
  }

  @Override
  public void handle(HttpExchange t) throws IOException {
    PrintWriter p = new PrintWriter (t.getResponseBody());

    p.println("<h1>Campuses:</h1>");

    p.println("<div class='list'>");
    for (Campus c : campuses) {
      p.println("<div class='list-item'>");
      p.println("<span>");
      p.println(c.getName());
      p.println("</span>");
      p.println("</div>");
    }
    p.println("</div>");

    t.sendResponseHeaders(200, 1024);

    p.close();
  }

}
