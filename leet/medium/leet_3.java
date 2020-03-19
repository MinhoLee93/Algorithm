class Solution {
    public int lengthOfLongestSubstring(String s) {
        int max = 0;
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < s.length(); i++) {
			String temp = s.substring(i, i + 1);
			// duplicate
			if (sb.indexOf(temp) != -1) {
				int index = sb.indexOf(temp);
				for (int j = 0; j <= index; j++) {
					sb.deleteCharAt(0);
				}
			}
			
			sb.append(temp);
			if (sb.length() > max) {
				max = sb.length();
			}
		}
		
		return max;
    }
}