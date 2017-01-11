import java.util.*;

public class RedBlackTree {

  private static Scanner input;

  public static void testCase(int x) {
    String[] strs = input.nextLine().split(" ");
    int[] nums = new int[strs.length];
    for (int i = 0; i < nums.length; i++) {
      nums[i] = Integer.parseInt(strs[i]);
    }
    System.out.println("Case #" + x + ": " + Arrays.toString(nums));
  }

  public static void main(String[] args) {
    input = new Scanner(System.in);
    int x = Integer.parseInt(input.nextLine());
    for (int i = 1; i <= x; i++) {
      testCase(i);
    }
  }

  private static class Tree {

    private Node head;

    private final Node NULL_NODE = new Node(null);

    Tree() {

    }

    private final int compare(Comparable item, Node t) {
      if (t == head) {
        return 1;
      } else {
        return item.compareTo(t.element);
      }
    }

    void insert(Comparable item) {

    }

    void remove(Comparable item) {

    }

    Comparable find(Comparable item) {
      return null;
    }

    Comparable findMin() {
      return null;
    }

    Comparable findMax() {
      return null;
    }

    void reorient(Comparable item) {

    }

    Node rotate(Comparable item, Node parent) {

    }

    private Node rotateWithleft(Node parent) {

    }

    private Node rotateWithRight(Node parent) {

    }

    boolean isEmpty() {
      return head.right == NULL_NODE;
    }

    void makeEmpty() {

    }

    void printTree() {
      printTree(head.right);
    }

    private void printTree(Node t) {
      if (t != NULL_NODE) {
        printTree(t.left);
        System.out.println(t.element);
        printTree(t.right);
      }
    }

    private static class Node {

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
  }
}
