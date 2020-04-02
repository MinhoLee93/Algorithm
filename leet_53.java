class Solution {
    public int maxSubArray(int[] nums) {
        int max = nums[0];
        int result = nums[0];

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > max + nums[i]) {
                max = nums[i];
                if (max > result) {
                    result = max;
                }
            } else {
                if (max > result) {
                    result = max;
                }
                max = max + nums[i];
            }
        }

        if (max > result) {
            result = max;
        }

        return result;
    }
}