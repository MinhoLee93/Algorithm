class Solution {
    public int titleToNumber(String s) {
        return solve(s, 0);
    }
    
    static int solve(String s, int cnt){
        if (s == null || s.equals("")) {
			return 0;
		}

		return solve(s.substring(0, s.length() - 1), cnt + 1)
				+ (s.charAt(s.length() - 1) - 64) * (int) Math.pow(26, cnt);
    }
}