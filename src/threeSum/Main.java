package threeSum;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        int[] nums = {-1,0,1,2,-1,-4};
        List<List<Integer>> ls = new ArrayList<>(); // {{-1,-1,2},{-1,0,1}}
        System.out.println(threeSum2(nums).toString());

    }

    public static int[] twoSumSortedArray(int[] arr, int sum, int first1, int last1) {
        int[] ans = new int[4];
        int first = first1;
        int last = last1;

        while (first != last) {

            if (arr[first] + arr[last] == sum) {
                ans[0] = first;
                ans[1] = arr[first];
                ans[2] = last;
                ans[3] = arr[last];
                return ans;

            } else if (arr[first] + arr[last] > sum) {
                last--;
            } else {
                first++;
            }
        }
        return null;
    }

    //my soll
    public static List<List<Integer>> threeSum(int[] nums) {
        int[] dup = nums.clone();
        Arrays.sort(dup);
        List<List<Integer>> ans = new ArrayList<>();
        for (int i = 0; i < dup.length - 2; i++) {
            int[] temp = twoSumSortedArray(dup, 0 - nums[i], i + 1, nums.length - 1);
            if (temp != null && (i != temp[0]) && (i != temp[2])) {
                List<Integer> innerList = new ArrayList<>();
                innerList.add(nums[i]);
                innerList.add(temp[1]);
                innerList.add(temp[3]);
                ans.add(innerList);
            }
        }
        return ans;
    }

    public static List<List<Integer>> threeSum2(int[] nums) {
        Set<List<Integer>> set = new HashSet<>(); // no dup in sets
        if (nums.length < 3) return new ArrayList<>(set);
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            int j = i + 1;
            int k = nums.length - 1;

            while (j < k) {
                int sum = nums[i] + nums[j] + nums[k];
                if (sum == 0) {
                    set.add(Arrays.asList(nums[i], nums[j++], nums[k--]));
                    /*
                    the same as:
                    set.add(Arrays.asList(nums[i], nums[j], nums[k]));
                    j++;
                    i--;
                     */
                } else if (sum > 0) {
                    k--;
                } else {
                    j++;
                }
            }
        }
        return new ArrayList<>(set);
    }
}

