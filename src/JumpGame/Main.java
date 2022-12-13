package JumpGame;

public class Main {
    public static void main(String[] args) {
        int[] nums1 = {2, 3, 1, 1, 4};
        int[] nums2 = {3, 2, 1, 0, 4};

        boolean ans1 = canJump(nums1);
        boolean ans2 = canJump(nums2);
        if (ans1 && !ans2) {
            System.out.println("correct");
        } else {
            System.out.println("wrong, " + "ans1 is: " + ans1 + ", ans2 is " + ans2);
        }

    }


    public static boolean canJump(int[] nums) {
        if (nums.length == 1) {
            return true;
        }
        int reachable = 0;
        for (int index = 0; index < nums.length; index++) {
            reachable = Math.max(reachable, index + nums[index]);
            if (index >= reachable) {
                return false;
            }
            if (reachable >= nums.length - 1) {
                return true;
            }

        }
        return false;
    }
/*
    public static boolean canJump(int[] nums) {
        return canJumpRec(nums, 0, nums.length - 1);
    }

    public static boolean canJumpRec(int[] nums, int index, int lastPlace) {
        if (index > lastPlace) {
            return false;
        }
        if (lastPlace - nums[index] <= 0) {
            return true;
        } else {
            boolean tempAns = false;
            for (int i = 1; i < nums[index]; i++) {
                tempAns = tempAns || canJumpRec(nums, index + i, lastPlace - i);
            }
            if (!tempAns) {
                return canJumpRec(nums, index + 1, lastPlace);
            } else {
                return true;
            }
        }
    }

 */
}
