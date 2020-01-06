class Solution {
    public String convertToTitle(int n) {
        if (n == 0) {
			return "";
		}

		char s = (char) ((n - 1) % 26 + 65);
		return convertToTitle((n - 1) / 26) + String.valueOf(s);
    }
}