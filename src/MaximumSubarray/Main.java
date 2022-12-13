package MaximumSubarray;

public class Main {
    public static void main(String[] args) {
        int[] nums1 = {-2, 1, -3, 4, -1, 2, 1, -5, 4};//
        int[] nums2 = {5, 4, -1, 7, 8};
        int[] nums3 = {1};
        int[] nums4 = {5,-1};
        System.out.println(maxSubArray(nums4));
        if (maxSubArray(nums1) == 6 && maxSubArray(nums2) == 23 && maxSubArray(nums3) == 1) {
            System.out.println("correct");
        } else {
            System.out.println("wrong");
        }
    }


    public static int maxSubArray(int[] nums) {
        int max = nums[0];
        int maxUntilCurrIndex = nums[0];
        for (int i = 1; i < nums.length; i++) {
            maxUntilCurrIndex = Math.max(maxUntilCurrIndex + nums[i], nums[i]);
            max = Math.max(max, maxUntilCurrIndex);
        }
        return max;
    }

}