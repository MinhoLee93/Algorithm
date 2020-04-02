class Solution {
    public int countSegments(String s) {

        String[] tt = s.split("\\s+");
        int cnt = 0;
        for (String t : tt) {
            if (t.length() > 0) {
                cnt++;
            }
        }

        return cnt;
    }
}