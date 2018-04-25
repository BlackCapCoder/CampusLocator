package Html;

import java.io.OutputStream;
import java.io.PrintWriter;


public class HtmlWriter extends PrintWriter {
  private long size = 0;

  public HtmlWriter (OutputStream os) {
    super(os);
  }

  public long getSize () { return this.size; }

  public void tag (Tag t) {
    print(t.toString());
  }

  public void print (String str) {
    size += str.length();
    super.print(str);
  }

}
