import java.util.*;

public class Quicksort {

  private static Scanner input;
  private static Random rnd;

  public static void testCase(int x) {
    String[] strs = input.nextLine().split(" ");
    int[] nums = new int[strs.length];
    for (int i = 0; i < nums.length; i++) {
      nums[i] = Integer.parseInt(strs[i]);
    }
    nums = quicksort(nums, 0, nums.length - 1);
    System.out.println("Case #" + x + ": " + Arrays.toString(nums));
  }

  public static int[] quicksort(int[] nums, int low, int high) {
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
          i++;
          j--;
      }
    }
    if (low < j) {
      nums = quicksort(nums, low, j);
    }
    if (i < high) {
      nums = quicksort(nums, i, high);
    }
    return nums;
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
