package searchInRotatedSortedArray;

public class Main {
    public static void main(String[] args) {
        int[] arr = {4, 5, 6, 7, 0, 1, 2};
        int[] arr1 = {5, 6, 7, 8, 9, 10, 11, 12, 13, 0, 1, 2, 3, 4};
        int ans1 = search(arr1 , 6);
        System.out.println(ans1);


    }


    static int findPivot(int arr[]) {
        int start = 0;
        int end = arr.length - 1;
        while (start < end) {
            int mid = start + (end - start) / 2;
            if (arr[mid] > arr[end]) {
                start = mid + 1;
            } else {
                end = mid;
            }

        }
        return start;
    }

    public static int binarySearch(int arr[], int l, int r, int x) {
        if (r >= l) {
            int mid = l + (r - l) / 2;
            if (arr[mid] == x)
                return mid;
            if (arr[mid] > x)
                return binarySearch(arr, l, mid - 1, x);
            return binarySearch(arr, mid + 1, r, x);
        }
        return -1;
    }


    public static int search(int[] nums, int target) {
        int ans = -1;
        int pivotIndex = findPivot(nums);

        if (nums[pivotIndex] == target) {
            ans = pivotIndex;
        } else if (nums[pivotIndex] > target && target < nums[nums.length - 1]) {
            ans = binarySearch(nums, pivotIndex + 1, nums.length - 1, target);
        } else {
            ans = binarySearch(nums, 0, pivotIndex, target);
        }
        return ans;
    }


}





















