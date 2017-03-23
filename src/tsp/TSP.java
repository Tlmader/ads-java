import java.util.Random;

public class TSP {

  static int totalCities = 3;
  static City[] cities;
  static Random rnd;

  static void setup() {
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

  static void solve() {

  }

  static int calcDistance() {
    return 0;
  }

  public static void main(String[] args) {
    rnd = new Random();
    setup();
    solve();
    for (City c : cities) {
      System.out.println(c.toString());
    }
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
