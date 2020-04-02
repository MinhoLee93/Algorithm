class Solution {
    public boolean isSubsequence(String s, String t) {
        int check = -1;
        for (int i = 0; i < s.length(); i++) {
            String temp = s.substring(i, i + 1);

            // ���� ���
            int find = t.indexOf(temp, check + 1);
            if (find != -1) {
                check = find;
            } else {
                return false;
            }
        }
        return true;
    }
}