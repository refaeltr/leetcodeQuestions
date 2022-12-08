package PartitionLabels;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        String test = "ababcbacadefegdehijhklij"; //Output: [9,7,8]

        System.out.println(partitionLabels(test).toString());

    }

    public static List<Integer> partitionLabels(String s) {
        int[] indexesOfLastAppearance = new int[26];
        int prev = 0;
        for (int i = 0; i < s.length(); i++) {
            indexesOfLastAppearance[s.charAt(i) - 97] = i;
        }
        List<Integer> ans = new ArrayList<>();
        int loopIndex = 0;
        while (loopIndex < s.length()) {
            int partitionIndex = indexesOfLastAppearance[s.charAt(loopIndex) - 97];
            for (int i = loopIndex; i <= partitionIndex; i++) { // loop for the assumed partition
                partitionIndex = Math.max(partitionIndex, indexesOfLastAppearance[s.charAt(i) - 97]);
            }
            ans.add(partitionIndex + 1 - prev);
            prev = partitionIndex + 1;
            loopIndex = partitionIndex + 1;
        }
        return ans;
    }
}
