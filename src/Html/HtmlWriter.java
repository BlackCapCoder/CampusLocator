package Html;

import java.io.OutputStream;
import java.io.PrintWriter;


public class HtmlWriter extends PrintWriter {
  public HtmlWriter (OutputStream os) {
    super(os);
  }

  public void tag (Tag t) {
    print(t.toString());
  }
}
