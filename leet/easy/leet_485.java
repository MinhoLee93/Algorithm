class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
       		int max = Integer.MIN_VALUE;
		int cnt = 0;
		for (int n : nums) {
			if (n == 0) {
				if (cnt > max) {
					max = cnt;
				}
				cnt = 0;
			} else {
				cnt++;
			}
		}

		if (cnt > max) {
			max = cnt;
		}

		return max;
    }
}