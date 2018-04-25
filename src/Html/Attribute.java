package Html;

import java.util.ArrayList;
import java.util.Collection;
import java.lang.StringBuilder;

public class Attribute {
  String name;
  ArrayList<String> values = new ArrayList<String> ();

  public Attribute (String name) {
    this.name = name;
  }
  public Attribute (String name, String value) {
    this.name = name;
    this.values.add(value);
  }
  public Attribute (String name, Collection<String> values) {
    this.name = name;
    this.values.addAll(values);
  }

  public String toString () {
    StringBuilder sb = new StringBuilder();

    sb.append(this.name);

    if (values.size() > 0) {
      boolean first = true;

      sb.append("=\"");
      for (String v : this.values) {
        if (!first) sb.append(" ");
        first = false;
        sb.append(v);
      }
      sb.append("\"");
    }

    return sb.toString();
  }
}
