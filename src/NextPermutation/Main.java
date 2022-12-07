package NextPermutation;

import java.lang.reflect.Array;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] test1 = {1, 2, 3};
        int[] ans1 = {1, 3, 2};
        nextPermutation(test1);
        boolean ts1 = Arrays.equals(test1, ans1);

        int[] test2 = {3, 2, 1};
        int[] ans2 = {1, 2, 3};
        nextPermutation(test2);
        System.out.println(Arrays.toString(test2));
        boolean ts2 = Arrays.equals(test2, ans2);

        int[] test3 = {1, 1, 5};
        int[] ans3 = {1, 5, 1};
        nextPermutation(test3);
        System.out.println(Arrays.toString(test3));
        boolean ts3 = Arrays.equals(test3, ans3);
        if (ts1 && ts2 && ts3) {
            System.out.println("correct");
        } else {
            System.out.println("wrong");
        }
    }

    public static int findSmallestThatBigger(int[] numbers, int index) {
        int indexOfAns = numbers.length - 1;
        int numberToCompareWith = numbers[index];
        for (int i = numbers.length - 1; i > index; i--) {
            if (numbers[i] > numberToCompareWith && numbers[i] >= numbers[indexOfAns]) {
                indexOfAns = i;
            }

        }
        return indexOfAns;
    }

    public static void swap(int[] arr, int idx1, int idx2) {
        int temp = arr[idx1];
        arr[idx1] = arr[idx2];
        arr[idx2] = temp;
    }

    public static void reverse(int[] nums, int start) {
        int i = start, j = nums.length - 1;
        while (i < j) {
            swap(nums, i, j);
            i++;
            j--;
        }
    }

    // Time complexity : O(n)O(n). In worst case, only two scans of the whole array are needed.
    public static void nextPermutation(int[] nums) {
        boolean flag = true;
        for (int i = nums.length - 2; i > 0; i--) {
            if (nums[i] >= nums[i - 1]) {
                int toSwapIndex = findSmallestThatBigger(nums, i);
                swap(nums, i, toSwapIndex);
                reverse(nums, i+1);
                flag = false;
                break;
            }

        }
        if (flag) {
            reverse(nums, 0);
        }
    }
}
