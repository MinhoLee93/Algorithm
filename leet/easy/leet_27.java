class Solution {
    public int removeElement(int[] nums, int val) {
        if (nums.length == 0 || nums == null) {
			return 0;
		}
		
		int index = 0;
		int result = 0;
		
		for(int n : nums) {
			if(n!=val) {
				nums[index++] = n;
				result++;
			}
		}
		
		return result;
    }
}