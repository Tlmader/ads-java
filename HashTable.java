import java.util.*;

public class HashTable {

private static Scanner input;
private static final int TABLE_SIZE = 128;

  private Entry[] entries;

  HashTable(int size) {
    entries = new Entry[size];
  }

  int get(int key) {
    int h = hash(key);
    while (entries[h] != null && entries[h].getKey() != key) {
      h = collision(h);
    }
    if (entries[h] == null) {
      return -1;
    } else {
      return entries[h].getValue();
    }
  }

  void put(int key, int value) {
    int h = hash(key);
    while (entries[h] != null && entries[h].getKey() != key) {
      h = collision(h);
    }
    entries[h] = new Entry(key, value);
  }

  private int hash(int key) {
    return key % entries.length;
  }

  private int collision(int h) {
    return (h + 1) % entries.length;
  }

  private static class Entry {

    private int key;
    private int value;

    Entry(int key, int value) {
      this.key = key;
      this.value = value;
    }

    int getKey() {
      return this.key;
    }

    int getValue() {
      return this.value;
    }
  }

  private static void testCase(int x) {
    int n = Integer.parseInt(input.nextLine());
    int[] keys = new int[n];
    HashTable table = new HashTable(TABLE_SIZE);
    for (int i = 0; i < n; i++) {
      String[] entry = input.nextLine().split(" ");
      int key = Integer.parseInt(entry[0]);
      int value = Integer.parseInt(entry[1]);
      keys[i] = key;
      table.put(key, value);
    }
    for (int i = 0; i < n; i++) {
      System.out.println("Case " + x + ", Entry " + i + ": Key: " + keys[i] + ", Value: " + table.get(keys[i]));
    }
  }

  public static void main(String[] args) {
    input = new Scanner(System.in);
    int x = Integer.parseInt(input.nextLine());
    for (int i = 1; i <= x; i++) {
      testCase(i);
    }
  }
}
