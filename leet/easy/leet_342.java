class Solution {
    public boolean isPowerOfFour(int num) {
        if (num == 1) {
			return true;
		}

		if (num / 4 > 0 && num % 4 == 0) {
			return isPowerOfFour(num / 4);
		} else {
			return false;
		}
    }
}