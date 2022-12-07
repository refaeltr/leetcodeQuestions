package ContainerWithMostWater;

public class Main {
    public static void main(String[] args) {
        int[] height1 = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        int[] height2 = {1, 1};
        if (maxArea(height1) == 49 && maxArea(height2) == 1) {
            System.out.println("correct");
        } else {
            System.out.println("wrong");
        }
    }

    public static int maxArea(int[] height) {
        int first = 0;
        int last = height.length - 1;
        int maxArea = 0;
        while (first < last) {
            int tempArea = Math.min(height[first], height[last]) * (last - first);
            maxArea = Math.max(maxArea, tempArea);
            if (height[first] > height[last]) {
                last--;
            } else {
                first++;
            }
        }

        return maxArea;
    }


    //trivial solution--> O(n^2)
    public static int maxArea1(int[] height) {
        int max = 0;
        for (int i = 0; i < height.length; i++) {
            for (int j = i + 1; j < height.length; j++) {
                int area = Math.min(height[i], height[j]) * Math.abs(i - j);
                if (area > max) {
                    max = area;
                }
            }
        }
        return max;
    }
}
