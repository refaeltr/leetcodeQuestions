package GroupAnagrams;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        System.out.println(groupAnagrams(strs).toString());
        //the answer is: [["bat"],["nat","tan"],["ate","eat","tea"]]
    }



// time complexity: O(K)
    public static boolean checkIfAnagrams(String str1, String str2) {
        if (str1.length() != str2.length()) {
            return false;
        } else {
            for (char ch : str1.toCharArray()) {
                if (!str2.contains("" + ch)) {
                    return false;
                }
            }
        }
        return true;
    }

    //time complexity is: N*K --> O(NK)
    public static List<List<String>> groupAnagrams(String[] strs) {
        if (strs == null || strs.length == 0) return new ArrayList<>();
        List<List<String>> ans = new ArrayList<>();
        for (int i = 0; i < strs.length; i++) {
            if (strs[i].equals("@")){continue;}
            List<String> temp = new ArrayList<>();
            temp.add(strs[i]);
            for (int j = i + 1; j < strs.length; j++) {
                if (checkIfAnagrams(strs[i], strs[j])) {
                    temp.add(strs[j]);
                    strs[j]="@";
                }
            }
            strs[i]="@";
            ans.add(temp);
        }
        return ans;
    }
}
