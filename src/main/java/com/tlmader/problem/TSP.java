package com.tlmader.problem;

import java.util.Random;

@SuppressWarnings("WrongPackageStatement")
public class TSP {

  static int totalCities = 10;
  static Random rnd;

  private static City[] setup() {
    City[] cities = new City[totalCities];
    for (int i = 0; i < cities.length; i++) {
      cities[i] = new City(rnd.nextInt(100), rnd.nextInt(100));
    }
    return cities;
  }

  static City[] swap(City[] cities, int i, int j) {
    City temp = cities[i];
    cities[i] = cities[j];
    cities[j] = temp;
    return cities;
  }

  static City[] solveWithRandomSwap(City[] cities, int iters) {
    int min = Integer.MAX_VALUE;
    City[] best = null;
    for (int i = 0; i < iters; i++) {
      swap(cities, rnd.nextInt(cities.length), rnd.nextInt(cities.length));
      int distance = calcDistance(cities);
      if (distance < min) {
        min = distance;
        best = cities.clone();
      }
    }
    return best;
  }

  static int calcDistance(City[] cities) {
    int distance = 0;
    for (int i = 0; i < cities.length - 1; i++) {
      distance += Math.sqrt(Math.pow(cities[i].x - cities[i + 1].x, 2) +
                            Math.pow(cities[i].y - cities[i + 1].y, 2));
    }
    distance += Math.sqrt(Math.pow(cities[0].x - cities[cities.length - 1].x, 2) +
        Math.pow(cities[0].y - cities[cities.length - 1].y, 2));
    return distance;
  }

  static void print(City[] cities) {
    for (City c : cities) {
      System.out.println(c.toString());
    }
    System.out.println(calcDistance(cities));
  }

  public static void main(String[] args) {
    rnd = new Random();
    City[] cities = setup();
    System.out.println("Shortest path found with random swap:");
    print(solveWithRandomSwap(cities, 10000));
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
