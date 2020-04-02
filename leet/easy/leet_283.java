class Solution {
    public void moveZeroes(int[] nums) {
        int cnt = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                for (int j = i; j < nums.length - 1; j++) {
                    nums[j] = nums[j + 1];
                }
                nums[nums.length - 1] = 0;
                i--;
            }

            cnt++;
            if (cnt == nums.length) {
                break;
            }
        }
    }
}