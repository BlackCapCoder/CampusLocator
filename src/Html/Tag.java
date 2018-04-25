package Html;

import java.util.ArrayList;
import java.util.Collection;
import java.lang.StringBuilder;


public class Tag {
  String name;
  ArrayList<Attribute> attrs = new ArrayList<Attribute> ();
  ArrayList<Object>    content = new ArrayList<Object> ();

  public Tag (String name) {
    this.name = name;
  }

  public Tag (String name, Collection<Attribute> attrs) {
    this.name = name;
    this.attrs.addAll(attrs);
  }

  public Tag child (Object c) {
    this.content.add(c);
    return this;
  }

  public Tag Class (String name) {
    this.attrs.add(new Attribute("class", name));
    return this;
  }

  public String toString () {
    StringBuilder sb = new StringBuilder();

    sb.append("<" + name);
    for (Attribute a : attrs) {
      sb.append(" " + a.toString());
    }
    sb.append(">");

    for (Object o : content) {
      sb.append(o.toString());
    }

    sb.append("</" + name + ">");

    return sb.toString();
  }

}
