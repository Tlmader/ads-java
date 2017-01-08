import java.math.*;
import java.util.*;

public class QuickSort {

  private static Scanner input;
  private static boolean debug = true;
  private static Random rnd;

  public static void testCase(int x) {
    String[] strs = input.nextLine().split(" ");
    int[] nums = new int[strs.length];
    for (int i = 0; i < nums.length; i++) {
      nums[i] = Integer.parseInt(strs[i]);
    }
    nums = quickSort(nums, 0, nums.length - 1);
    printCase(x, Arrays.toString(nums));
  }

  public static int[] quickSort(int[] nums, int low, int high) {
    if (nums == null || nums.length == 0) {
      return null;
    }
    int pivot = rnd.nextInt(high - low) + low + 1;
    int i = low;
    int j = high;
    while (i <= j) {
      while (nums[i] < pivot) {
        i++;
      }
      while (nums[j] > pivot) {
        j--;
      }
      if (i <= j) {
          int temp = nums[i];
          nums[i] = nums[j];
          nums[j] = temp;
          log(nums[i] + " <-> " + nums[j] + ": " + Arrays.toString(nums));
          i++;
          j--;
      }
    }
    if (low < j) {
      nums = quickSort(nums, low, j);
    }
    if (i < high) {
      nums = quickSort(nums, i, high);
    }
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
      System.out.println("LOG: " + message);
    }
  }

  public static void logNoBreak(String message) {
    if (debug) {
      System.out.print(message);
    }
  }

  public static void main(String[] args) {
    input = new Scanner(System.in);
    rnd = new Random();
    int x = parseIntFromLine();
    for (int i = 1; i <= x; i++) {
      testCase(i);
    }
  }
}
