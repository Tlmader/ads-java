//import java.util.*;
//
//public class SplayTree {
//
//  private Node root;
//
//  private static Scanner input;
//
//  public int get(int value) {
//    root = splay(root, value);
//    int cmp = Integer.compare(value, root.value);
//    if (cmp == 0) {
//      return root.value;
//    } else {
//      return -1;
//    }
//  }
//
//  public boolean contains(int value) {
//    return get(value) != -1;
//  }
//
//  public void put(int value) {
//    if (root == null) {
//      root = new Node(value);
//      return;
//    }
//    root = splay(root, value);
//    int cmp = Integer.compare(value, root.value);
//    if (cmp < 0) {
//      Node n = new Node(value);
//      n.left = root.left;
//      n.right = root;
//      root.left = null;
//      root = n;
//    } else if (cmp > 0) {
//      Node n = new Node(value);
//      n.right = root.right;
//      n.left = root;
//      root.right = null;
//      root = n;
//    }
//  }
//
//  public void remove(int value) {
//    if (root == null) {
//      return;
//    }
//    root = splay(root, value);
//    int cmp = Integer.compare(value, root.value);
//    if (cmp == 0) {
//      if (root.left == null) {
//        root = root.right;
//      } else {
//        Node x = root.right;
//        root = root.left;
//        splay(root, value);
//        root.right = x;
//      }
//    }
//  }
//
//  private Node splay(Node h, int value) {
//    if (h == null) {
//      return null;
//    }
//    int cmp = Integer.compare(value, h.value);
//    if (cmp < 0) {
//      if (h.left == null) {
//        return h;
//      }
//      cmp = Integer.compare(value, h.left.value);
//      if (cmp < 0) {
//        h.left.left = splay(h.left.left, value);
//        h = rotateRight(h);
//      } else
//    } else if (cmp > 0) {
//
//    } else {
//      return h;
//    }
//    return null;
//  }
//
//  private class Node {
//
//    private int value;
//    private Node left;
//    private Node right;
//
//    public Node(int value) {
//      this.value = value;
//    }
//  }
//
//  public static void testCase(int x) {
//    String[] strs = input.nextLine().split(" ");
//    int[] nums = new int[strs.length];
//    for (int i = 0; i < nums.length; i++) {
//      nums[i] = Integer.parseInt(strs[i]);
//    }
//    System.out.println("Case #" + x + ": " + Arrays.toString(nums));
//  }
//
//  public static void main(String[] args) {
//    input = new Scanner(System.in);
//    int x = Integer.parseInt(input.nextLine());
//    for (int i = 1; i <= x; i++) {
//      testCase(i);
//    }
//  }
//}
