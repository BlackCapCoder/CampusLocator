class Campus {
  String name;
  boolean isFavorite;
  String location;

  Campus (String name, boolean isFavorite, String location) {
    this.name       = name;
    this.isFavorite = isFavorite;
    this.location   = location;
  }

  public String  getName       () { return name; }
  public boolean getIsFavorite () { return isFavorite; }
  public String  getLocation   () { return location; }
}
