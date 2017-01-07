import java.math.*;
import java.util.*;

public class QuickSort {

  private static Scanner input;
  private static boolean debug = true;

  public static void testCase(int x) {
    String[] strs = input.nextLine().split(" ");
    int[] nums = new int[strs.length];
    for (int i = 0; i < nums.length; i++) {
      nums[i] = Integer.parseInt(strs[i]);
    }
    nums = quickSort(nums);
    printCase(x, Arrays.toString(nums));
  }

  public static int[] quickSort(int[] nums) {
    return nums;
  }

  public static int parseIntFromLine() {
    return Integer.parseInt(input.nextLine());
  }

  public static void printCase(int num, Object result) {
    System.out.println("Case #" + num + ": " + result);
  }

  public static void log(String message) {
    if (debug) {
      System.out.println(message);
    }
  }

  public static void logNoBreak(String message) {
    if (debug) {
      System.out.print(message);
    }
  }

  public static void main(String[] args) {
    input = new Scanner(System.in);
    int x = parseIntFromLine();
    for (int i = 1; i <= x; i++) {
      testCase(i);
    }
  }
}
