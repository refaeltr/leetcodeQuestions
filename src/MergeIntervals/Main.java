package MergeIntervals;

import FindThePointWhereMaximumIntervalsOverlap.Time;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        int[][] intervals1 = {{1, 3}, {2, 6}, {8, 10}, {15, 18}};
        int[][] intervals2 = {{1, 4}, {4, 5}};
        int[][] ans1 = merge(intervals1);
        int[][] ans2 = merge(intervals2);
        print2DArray(ans1);
        print2DArray(ans2);

    }

    public static int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (int[] a, int[] b) -> Integer.compare(a[0], b[0]));
        LinkedList<int[]> merged = new LinkedList<>();
        for (int[] interval : intervals) {
            if (merged.isEmpty() || merged.getLast()[1] < interval[0]) {
                merged.add(interval);
            } else {
                merged.getLast()[1] = Math.max(merged.getLast()[1], interval[1]);
            }
        }
        return merged.toArray(new int[merged.size()][]);
    }

    public static void print2DArray(int[][] lst) {
        for (int[] arr : lst) {
            System.out.println(Arrays.toString(arr));
        }
    }


}
