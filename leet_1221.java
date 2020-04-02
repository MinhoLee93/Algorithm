package leetcode;

public class leet_1221 {

    public static void main(String[] args) {
        String s = "RLLLLRRRLR";
        char[] c = s.toCharArray();

        int r = 0;
        int l = 0;
        int result = 0;

        for (char i : c) {
            if (i == 'R') {
                r++;
            } else if (i == 'L') {
                l++;
            }

            if (r + l != 0 && r == l) {
                result++;
                r = 0;
                l = 0;
            }
        }

        //return result;
    }
}
