/**
 * Runtime: 18 ms, faster than 37.38% of Java online submissions for Two Sum.
 * Memory Usage: 36.6 MB, less than 99.48% of Java online submissions for Two Sum.
 */
class Solution {
    public int[] twoSum(int[] nums, int target) {

        for (int i = 0; i < (nums.length - 1); i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    int[] result = new int[2];
                    result[0] = i;
                    result[1] = j;

                    return result;
                }
            }
        }

        return null;
    }
}