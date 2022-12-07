package LongestCommonPrefix_Q;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        String[] strs1 = {"flower", "flow", "flight"};
        String[] strs2 = {"dog", "racecar", "car"};
        String ans1 = longestCommonPrefix(strs1);
        String ans2 = longestCommonPrefix(strs2);


        if (ans1.equals("fl") && ans2.equals("")) {
            System.out.println("correct");
        } else {
            System.out.println("wrong");
        }
    }


        public static String longestCommonPrefix(String[] strs) {
            String ans = "";
            if (strs.length == 0) return "";

            for (int i = 1; i < strs[0].length(); i++) {
                boolean flag = true;
                String prefix = strs[0].substring(0, i);
                for (String el : strs) {
                    if (el.equals(strs[0])) {
                    } else {
                        if (!el.startsWith(prefix)) {
                            flag = false;
                            break;
                        }
                    }
                }
                if (flag && prefix.length() > ans.length()) {
                    ans = prefix;
                }
            }

            return ans;
        }


}
