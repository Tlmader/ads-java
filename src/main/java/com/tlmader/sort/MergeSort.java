package com.tlmader.sort;

import java.util.*;

public class MergeSort {

  private static Scanner input;

  public static void testCase(int x) {
    String[] strs = input.nextLine().split(" ");
    int[] nums = new int[strs.length];
    for (int i = 0; i < nums.length; i++) {
      nums[i] = Integer.parseInt(strs[i]);
    }
    nums = mergeSort(nums, 0, nums.length - 1);
    System.out.println("Case #" + x + ": " + Arrays.toString(nums));
  }

  public static int[] mergeSort(int[] nums, int low, int high) {
    if (low >= high) {
      return nums;
    }
    int mid = low + (high - low) / 2;
    nums = mergeSort(nums, low, mid);
    nums = mergeSort(nums, mid + 1, high);
    int[] temp = new int[nums.length];
    for (int i = low; i <= high; i++) {
      temp[i] = nums[i];
    }
    int i = low;
    int j = mid + 1;
    int k = low;
    while (i <= mid && j <= high) {
      if (temp[i] <= temp[j]) {
        nums[k++] = temp[i++];
      } else {
        nums[k++] = temp[j++];
      }
    }
    while (i <= mid) {
      nums[k++] = temp[i++];
    }
    return nums;
  }

  public static void main(String[] args) {
    input = new Scanner(System.in);
    int x = Integer.parseInt(input.nextLine());
    for (int i = 1; i <= x; i++) {
      testCase(i);
    }
  }
}
