import java.io.IOException;
import java.io.OutputStream;
import java.io.ByteArrayOutputStream;
import java.net.InetSocketAddress;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Files;
import java.util.function.Consumer;


class HttpMonoid implements HttpHandler {
  private Consumer<OutputStream> handler;

  public Consumer<OutputStream> getHandler () {
    if (this.handler != null) return this.handler;
    return (os) -> this.write(os);
  }

  public void setHandler (Consumer<OutputStream> h) {
    this.handler = h;
  }

  // Override this; default is the unit
  public void write (OutputStream os) {}

  // Monoid composition
  public HttpMonoid append (HttpMonoid other) {
    this.setHandler( this.getHandler().andThen(other.getHandler()) );
    return this;
  }


  @Override
  public void handle(HttpExchange t) throws IOException {
    OutputStream os = t.getResponseBody();
    ByteArrayOutputStream bs = new ByteArrayOutputStream ();

    getHandler().accept(bs);

    t.sendResponseHeaders(200, bs.size());
    bs.writeTo(os);

    os.flush();
    os.close();
  }

}
