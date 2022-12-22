package HouseRobber;

public class Main {
    public static void main(String[] args) {
        int[] nums1 = {1, 2, 3, 1};
        int[] nums2 = {2, 7, 9, 3, 1};
        int[] nums3 = {2, 1, 1, 2};// dp = [2 , 2 , 3 , 2+2=4]
        int ans1 = rob(nums1);
        int ans2 = rob(nums2);
        int ans3 = rob(nums3);
        if (ans1 == 4 && ans2 == 12 && ans3 == 4) {
            System.out.println("correct");
        } else {
            System.out.println("wrong --> " + ans1 + " , " + ans2 + " , " + ans3);
        }

    }

    //-----------------dynamic programming solution----
    public static int rob(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        if (nums.length == 2) {
            return Math.max(nums[0], nums[1]);
        }
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        for (int i = 2; i < dp.length; i++) {
            dp[i] = Math.max(nums[i] + dp[i - 2], dp[i - 1]);
        }
        return dp[nums.length - 1];
    }

    //--------------------------linear sol----
    public static int rob2(int[] nums) {
        int rob = 0; //max monney can get if rob current house
        int notrob = 0; //max money can get if not rob current house
        for (int i = 0; i < nums.length; i++) {
            int currob = notrob + nums[i]; //if rob current value, previous house must not be robbed
            notrob = Math.max(notrob, rob); //if not rob ith house, take the max value of robbed (i-1)th house and not rob (i-1)th house
            rob = currob;
        }
        return Math.max(rob, notrob);
    }


    //--------------------------Rec SOl----------------------------
    /*
    public static int rob(int[] nums) {
        return robRec(nums, 0, 0);
    }

    public static int robRec(int[] nums, int index, int acc) {
        if (index > nums.length - 1) {
            return acc;
        }
        return Math.max(robRec(nums, index + 2, acc + nums[index]),
                robRec(nums, index + 1, acc));
    }

     */
}
