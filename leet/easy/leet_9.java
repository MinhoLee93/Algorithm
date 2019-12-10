class Solution {
    public boolean isPalindrome(int x) {
       if(x<0) {
			return false;
		}
		
		int p = x, q = 0;
		while (p >= 1) {
			q = q * 10;
			q += p % 10;
			p = p / 10;
		}

		return q == x;
    }
}