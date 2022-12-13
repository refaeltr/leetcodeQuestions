package FindFirstAndLastPositionOfElementInSortedArray;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] nums1 = {5, 7, 7, 8, 8, 10};
        int target1 = 8;
        int[] Output1 = {3, 4};

        int[] nums2 = {5, 7, 7, 8, 8, 10};
        int target2 = 6;
        int[] Output2 = {-1, -1};

        int[] nums3 = {};
        int target3 = 0;
        int[] Output3 = {-1, -1};
        boolean t1 = Arrays.equals(searchRange(nums1, target1), Output1);
        boolean t2 = Arrays.equals(searchRange(nums2, target2), Output2);
        boolean t3 = Arrays.equals(searchRange(nums3, target3), Output3);

        if (t1 && t2 && t3) {
            System.out.println("correct");
        } else {
            System.out.println("wrong");
        }
    }

    public static int[] searchRange(int[] nums, int target) {
        int[] ans = new int[2];
        ans[0] = findFirst(nums, target);
        ans[1] = findLast(nums, target);
        return ans;
    }


    private static int findFirst(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;
        int resultIndex = -1;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (nums[mid] >= target) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
            if (nums[mid] == target) {
                resultIndex = mid;
            }
        }
        return resultIndex;
    }

    private static int findLast(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;
        int resultIndex = -1;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (nums[mid] <= target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
            if (nums[mid] == target) {
                resultIndex = mid;
            }
        }
        return resultIndex;
    }

}
