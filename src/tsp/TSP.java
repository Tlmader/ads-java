import java.util.Random;

@SuppressWarnings("WrongPackageStatement")
public class TSP {

  static int totalCities = 10;
  static City[] cities;
  static Random rnd;

  private static void setup() {
    cities = new City[totalCities];
    for (int i = 0; i < cities.length; i++) {
      cities[i] = new City(rnd.nextInt(100), rnd.nextInt(100));
    }
  }

  static void swap(int i, int j) {
    City temp = cities[i];
    cities[i] = cities[j];
    cities[j] = temp;
  }

  static void solve(int iters) {
    int min = Integer.MAX_VALUE;
    City[] best = null;
    for (int i = 0; i < iters; i++) {
      swap(rnd.nextInt(cities.length), rnd.nextInt(cities.length));
      int distance = calcDistance();
      print();
      if (distance < min) {
        min = distance;
        best = cities.clone();
      }
    }
    cities = best;
  }

  static int calcDistance() {
    int distance = 0;
    for (int i = 0; i < cities.length - 1; i++) {
      distance += Math.sqrt(Math.pow(cities[i].x - cities[i + 1].x, 2) +
                            Math.pow(cities[i].y - cities[i + 1].y, 2));
    }
    distance += Math.sqrt(Math.pow(cities[0].x - cities[cities.length - 1].x, 2) +
        Math.pow(cities[0].y - cities[cities.length - 1].y, 2));
    return distance;
  }

  static void print() {
    for (City c : cities) {
      System.out.println(c.toString());
    }
    System.out.println(calcDistance());
  }

  public static void main(String[] args) {
    rnd = new Random();
    setup();
    solve(10000);
    System.out.println("Shortest path found:");
    print();
  }
}

class City {
  int x;
  int y;

  City(int x, int y) {
    this.x = x;
    this.y = y;
  }

  @Override
  public String toString() {
    return x + "," + y;
  }
}
