package RomanToInteger_Q;

/*
Symbol       Value
I             1
V             5
X             10
L             50
C             100
D             500
M             1000
 */
public class Main {
    public static void main(String[] args) {
        String s1 = "IIIIVIXIXIX"; //3+4+9+9=34
        String s2 = "LVIII"; //58
        String s3 = "MCMXCIV"; //1994
        String s4 = "IV"; //4
        String s5 = "IX"; //9
        String s6 = "XL"; //40
        String s7 = "XC"; //90
        String s8 = "CD"; //400
        String s9 = "CM"; //900
        int ss1 = romanToInt(s1);
        int ss2 = romanToInt(s2);
        int ss3 = romanToInt(s3);
        int ss4 = romanToInt(s4);
        int ss5 = romanToInt(s5);
        int ss6 = romanToInt(s6);
        int ss7 = romanToInt(s7);
        int ss8 = romanToInt(s8);
        int ss9 = romanToInt(s9);
        System.out.println(ss1 + " , " + ss2 + " , " + ss3 + " , " + ss4 + " , " + ss5 + " , " + ss6 + " , " + ss7 + " , " + ss8 + " , " + ss9 + " , ");
        if (ss1 == 34 && ss2 == 58 && ss3 == 1994 &&
                ss4 == 4 && ss5 == 9 && ss6 == 40 &&
                ss7 == 90 && ss8 == 400 && ss9 == 900) {
            System.out.println("correct");
        } else {
            System.out.println("wrong");
        }

    }

    public static int romanDigitToInteger(String romanDigit) {
        switch (romanDigit) {
            case "I":
                return 1;
            case "V":
                return 5;
            case "X":
                return 10;
            case "L":
                return 50;
            case "C":
                return 100;
            case "D":
                return 500;
            case "M":
                return 1000;
        }
        return -1;
    }

    public static int substructionCase(String roman_num) {
        switch (roman_num) {
            case "IV":
                return 4;
            case "IX":
                return 9;
            case "XL":
                return 40;
            case "XC":
                return 90;
            case "CD":
                return 400;
            case "CM":
                return 900;

        }
        return -1;
    }

    //"MCMXCIV" -->1994, M = 1000, CM = 900, XC = 90 and IV = 4.
    public static int romanToInt(String input) {
        int sum = 0;
        String[] matches = new String[]{"IV", "IX", "XL", "XC", "CD", "CM"};
        for (String s : matches) {
            while (input.contains(s)) {
                input = input.replaceFirst(s, "");
                sum += substructionCase(s);
            }
        }
        for (int i = 0; i < input.length(); i++) {
            sum += romanDigitToInteger("" + input.charAt(i));
        }

        return sum;
    }
}
