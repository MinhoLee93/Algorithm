class Solution {
    public int minMoves(int[] nums) {
        int currentsum = 0;
        int len = nums.length;
        int min = Integer.MAX_VALUE;

        for (int i = 0; i < nums.length; i++) {
            currentsum += nums[i];
            min = Math.min(min, nums[i]);
        }

        return currentsum - len * min;
    }
}