class Solution {
    public int threeSumClosest(int[] nums, int target) {
        if (nums.length == 3) {
            return nums[0] + nums[1] + nums[2];
        }

        int min = Integer.MAX_VALUE;
        int result = target;
        for (int i = 0; i < nums.length - 2; i++) {
            for (int j = i + 1; j < nums.length - 1; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    //System.out.println(nums[i] + "," + nums[j] + "," + nums[k]);
                    if (nums[i] + nums[j] + nums[k] == target) {
                        return target;
                    } else {
                        if (Math.abs(target - (nums[i] + nums[j] + nums[k])) < min) {
                            min = Math.abs(target - (nums[i] + nums[j] + nums[k]));
                            result = (nums[i] + nums[j] + nums[k]);
                            System.out.println("min : " + min);
                        }
                    }
                }
            }
        }

        return result;
    }
}