class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new LinkedList<>();
        Arrays.sort(nums);
        //print(nums);
        for (int i = 0; i < nums.length - 3; i++) {
            if(i>0 && (nums[i] == nums[i-1])){
                continue;
            }
            int Left = i;
            int Right = nums.length - 1;
            // 바깥 쪽
            while (Left + 2 < Right) {
                System.out.println(Left + " , " + Right);
                int Sum = nums[Left] + nums[Right];
                int left = Left + 1;
                int right = Right - 1;
                // 안쪽
                while (left < right) {
                    int sum = nums[left] + nums[right];
                    // 같을때
                    if (target - (Sum + sum) == 0) {
                        System.out.println(Left + " , " + left + " , " + right + " , " + Right);
                        result.add(Arrays.asList(nums[Left], nums[left], nums[right], nums[Right]));
                        while(left< right && nums[left]==nums[left+1]) left++;
                        while(left< right && nums[right]==nums[right-1]) right--;
                        left++;
                        right--;
                    } else if (target - (Sum + sum) > 0) {
                        left++;
                    } else if (target - (Sum + sum) < 0) {
                        right--;
                    }
                }
                while(Left + 2 < Right && (nums[Right] == nums[Right-1])){
                    Right--;
                }
                Right--;
            }
        }
        return result;
    }
}