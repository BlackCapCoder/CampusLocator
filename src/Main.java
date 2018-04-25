import com.sun.net.httpserver.HttpServer; // http server
import java.sql.*; // sqlite


class Main {

  public static void main (String[] args) throws Exception {
    Server s = new Server (8000);

    s.AddPage("", new FilePage("../data/index.html"));
    s.AddPage("test", new FilePage("../data/test.html"));
    s.AddPage("mob", new MobileMain(s.getCampuses()));

    s.Start();
  }

}
