class Solution {
    public boolean repeatedSubstringPattern(String s) {
        for (int i = 1; i <= s.length() / 2; i++) {
            String temp = s.substring(0, i);

            if (s.equals(mulitple(temp, s.length() / temp.length()))) {
                return true;
            }
        }

        return false;
    }

    public String mulitple(String s, int cnt) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < cnt; i++) {
            sb.append(s);
        }

        return sb.toString();
    }
}