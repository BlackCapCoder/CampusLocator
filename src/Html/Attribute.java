package Html;

public class Attribute {
  String name;
  String value;

  public Attribute (String name, String value) {
    this.name  = name;
    this.value = value;
  }

  public String toString () {
    return name + "=\"" + value + "\"";
  }
}
