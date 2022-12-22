package FindTheIndexOfTheFirstOccurrenceInAString;

public class Main {
    public static void main(String[] args) {
        String haystack1 = "sadbutsad";
        String needle1 = "sad";
        String haystack2 = "leetcode";
        String needle2 = "leeto";

        String haystack3 = "mississippi";
        String needle3 = "issipi";

        int ans1 = strStr(haystack1, needle1);
        int ans2 = strStr(haystack2, needle2);
        int ans3 = strStr(haystack3, needle3);
        if (ans1 == 0 && ans2 == -1 && ans3 == -1) {
            System.out.println("correct");
        } else {
            System.out.println("wrong -- > " + ans1 + " , " + ans2 + " , " + ans3);
        }

    }

//---------------------linear sol----------------------------------
    public static int strStr(String haystack, String needle) {
        if(haystack == null || needle == null || needle.length() > haystack.length()) return -1;

        int[] parr = kmpPreprocess(needle);
        int i = 0, j = 0;
        while(i < haystack.length() && j < needle.length()) {
            if(haystack.charAt(i) == needle.charAt(j)) {
                i++; j++;
            } else if(j > 0) {
                j = parr[j - 1];
            } else {
                i++;
            }
        }
        return j == needle.length() ? i - j : -1;
    }

    private static int[] kmpPreprocess(String pattern) {
        int i = 1, j = 0;
        int[] res = new int[pattern.length()];
        while(i < pattern.length()) {
            if(pattern.charAt(i) == pattern.charAt(j)) {
                res[i] = j+1;
                i++; j++;
            } else if (j > 0) {
                j = res[j-1];
            } else {
                res[i] = 0;
                i++;
            }
        }
        return res;
    }



















/*
    public static int strStr(String haystack, String needle) {
        if (needle.length() > haystack.length()) {
            return -1;
        }
        for (int i = 0; i < haystack.length(); i++) {
            boolean found = true;
            if (haystack.charAt(i) == needle.charAt(0) &&
                    (i + needle.length() <= haystack.length())) {
                for (int j = 1; j < needle.length() && (i + j < haystack.length()); j++) {
                    if (needle.charAt(j) != haystack.charAt(i + j)) {
                        found = false;
                        break;
                    }
                }
                if (found) {
                    return i;
                }
            }
        }
        return -1;
    }

 */
}
