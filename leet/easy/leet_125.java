import java.util.regex.*;

class Solution {
    public boolean isPalindrome(String s) {
        int head = 0;
        int tail = s.length() - 1;
        boolean result = false;

        if (s.trim().equals("")) {

        } else {
            while (head <= tail) {

                while (head <= tail && !isAlphaNumeric(s.charAt(head))) {
                    head++;
                }


                while (tail >= head && !isAlphaNumeric(s.charAt(tail))) {
                    tail--;
                }


                if (head <= tail && Character.toLowerCase(s.charAt(head)) == Character.toLowerCase(s.charAt(tail))) {
                    head++;
                    tail--;
                } else {
                    if (head <= tail) {
                        return false;
                    } else {
                        return true;
                    }
                }
            }
        }

        return true;
    }

    static boolean isAlphaNumeric(char c) {

        Pattern pattern = Pattern.compile("[a-zA-Z0-9]");
        Matcher matcher = pattern.matcher(String.valueOf(c));
        if (matcher.matches()) {
            return true;
        } else {
            return false;
        }
    }
}