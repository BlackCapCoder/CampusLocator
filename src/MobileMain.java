import java.io.IOException;
import java.net.InetSocketAddress;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Files;

import java.util.ArrayList;

import Html.*;


class MobileMain implements HttpHandler {
  ArrayList<Campus> campuses;

  public MobileMain (ArrayList<Campus> cs) {
    campuses = cs;
  }

  @Override
  public void handle(HttpExchange t) throws IOException {
    HtmlWriter p = new HtmlWriter (t.getResponseBody());

    p.print("<!DOCTYPE html>");

    p.print("<link rel='stylesheet' href='mob.css'/>");


    p.tag(new Tag("h1").child("Campuses:"));

    Tag lst = new Tag("div").Class("list");

    for (Campus c : campuses) {
      lst.child ( new Tag ("div")
                . Class ("list-item")
                . child ( new Tag ("span")
                        . Class ("title")
                        . child ( c.getName() )
                        )
                );
    }

    p.tag(lst);

    t.sendResponseHeaders(200, p.getSize());

    p.close();
  }

}
