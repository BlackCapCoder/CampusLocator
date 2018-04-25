import java.util.ArrayList;

// Represents instructions for traveling from A to B
class Directions {
  ArrayList<Campus> stops = new ArrayList<Campus> ();

  Directions (Campus origin, Campus destination) {
    stops.add(origin);
    stops.add(destination);
  }
  Directions () {}

  // Where to start
  public Campus getOrigin () {
    return stops.get(0);
  }

  // Where to end
  public Campus getDestination () {
    return stops.get(stops.size() - 1);
  }

  // Returns all stops on the travel
  public ArrayList<Campus> getStops () {
    return stops;
  }

  // Add a stop
  public void AddStop (Campus s) {
    stops.add(s);
  }

  // Directions are monoid
  public void Append (Directions other) {
    stops.addAll(other.getStops());
  }

  public static Directions Empty () { return new Directions (); }

}
