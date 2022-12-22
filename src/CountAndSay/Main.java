package CountAndSay;

public class Main {
    public static void main(String[] args) {
        String ans = "1211";
        for (int i = 1; i < 20; i++) {
            System.out.println(countAndSay(i));
        }

    }

    /*
    Input: n = 4
    Output: "1211"
    Explanation:
    countAndSay(1) = "1"
    countAndSay(2) = say "1" = one 1 = "11"
    countAndSay(3) = say "11" = two 1's = "21"
    countAndSay(4) = say "21" = one 2 + one 1 = "12" + "11" = "1211"
     */


    //--------------faster sol----------------------------------------------------
    public static String countAndSay(int n) {
        String str = "1";
        for (int i = 2; i <= n; i++) {
            StringBuilder sb = new StringBuilder();
            char[] chars = str.toCharArray();
            // char c = chars[0];
            int cnt = 1;
            for (int j = 1; j < str.length(); j++) {
                if (chars[j] != chars[j - 1]) {
                    sb.append(cnt).append(chars[j - 1]);
                    cnt = 0;
                }
                cnt++;
            }
            sb.append(cnt).append("1");
            str = sb.toString();
        }
        return str;
    }

    //-----------------------------------------------------------------------------
    public static String countAndSay1(int n) {
        if (n == 1) {
            return "1";
        }
        String ans = "1";
        for (int i = 1; i < n; i++) {
            ans = givenPrev(ans);
        }
        return ans;
    }

    //-----------------------------rec sol---------------------------------------
    public static String countAndSayRec(int n) {
        if (n == 1) {
            return "1";
        }
        String prev = countAndSayRec(n - 1);
        return givenPrev(prev);
    }

    //--------------------------------------------------------------------------------
    public static String givenPrev(String prev) {
        String ans = "";
        int i = 0;
        while (i < prev.length()) {
            char currentChar = prev.charAt(i);
            int say = 0;
            int j = i;
            while (j < prev.length()) {
                if (prev.charAt(j) == currentChar) {
                    say++;
                    j++;
                    if (j > prev.length() - 1) {
                        i = j;
                    }
                } else {
                    i = j;
                    break;
                }
            }
            ans = ans + Integer.toString(say) + currentChar;
        }
        return ans;
    }
}
