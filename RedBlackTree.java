import java.math.*;
import java.util.*;

public class RedBlackTree {

  private static Scanner input;

  public static void testCase(int x) {
    String[] strs = input.nextLine().split(" ");
    int[] nums = new int[strs.length];
    for (int i = 0; i < nums.length; i++) {
      nums[i] = Integer.parseInt(strs[i]);
    }
    nums = quicksort(nums, 0, nums.length - 1);
    System.out.println("Case #" + x + ": " + Arrays.toString(nums));
  }

  public static void main(String[] args) {
    input = new Scanner(System.in);
    rnd = new Random();
    int x = Integer.parseInt(input.nextLine());
    for (int i = 1; i <= x; i++) {
      testCase(i);
    }
  }
}

class Tree {

  private Node header;

  Tree() {

  }

  private final int compare(Comparable item, Node t) {
    if (t == head) {
      return 1;
    } else {
      return item.compareTo(t.element);
    }
  }

  private Node getNullNode() {
    return new Node(null);
  }
}

class Node {

  Comparable element;
  Node left;
  Node right;
  int color;

  private static final int BLACK = 1;
  private static final int RED = 0;

  Node(Comparable element) {
    this(element, null, null);
  }

  Node(Comparable element, Node left, Node right) {
    this.left = left;
    this.right = right;
    color = BLACK;
  }
}
