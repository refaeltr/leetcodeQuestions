package LetterCombinationsofAPhoneNumber;

import FindMaxBandwidth_Q.st;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        String digits = "23";
        Main mm = new Main();
        System.out.println(mm.letterCombinations(digits).toString());

    }

    public List<String> letterCombinations(String digits) {
        LinkedList<String> ans = new LinkedList<String>();
        if (digits.isEmpty()) {
            return ans;
        }
        String[] mapping = new String[]{"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        ans.add("");
        for (int i = 0; i < digits.length(); i++) {
            int index = digits.charAt(i) - '0'; // equals to:  Character.getNumericValue(i);
            while (ans.peek().length() == i) {
                String str = ans.remove();
                char[] arr = mapping[index].toCharArray();
                for (char ch : arr) {
                    ans.add(str + ch);
                }
            }
        }
        return ans;
    }
}
