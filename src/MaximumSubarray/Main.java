package MaximumSubarray;

public class Main {
    public static void main(String[] args) {
        int[] nums1 = {-2, 1, -3, 4, -1, 2, 1, -5, 4};//
        int[] nums2 = {5, 4, -1, 7, 8};
        int[] nums3 = {1};
        int[] nums4 = {5, -1};
        System.out.println(maxSubArray(nums4));
        if (maxSubArray(nums1) == 6 && maxSubArray(nums2) == 23 && maxSubArray(nums3) == 1) {
            System.out.println("correct");
        } else {
            System.out.println("wrong");
        }
    }

    public static int maxSubArray(int[] nums) {
        int ans = nums[0];
        int currentMax = nums[0];
        for (int i = 1; i < nums.length; i++) {
            currentMax = Math.max(currentMax + nums[i], nums[i]);
            ans = Math.max(ans, currentMax);
        }
        return ans;
    }




}