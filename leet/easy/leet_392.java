class Solution {
    public boolean isSubsequence(String s, String t) {
        int n = s.length(), m = t.length();
        
        int j = 0;
        for(int i = 0;j<n&&i<m;i++){
            if(s.charAt(j)==t.charAt(i)){
                j++;
            }
        }
        return j==n;
    }
}
