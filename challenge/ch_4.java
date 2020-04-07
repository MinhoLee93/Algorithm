class Solution {
    public void moveZeroes(int[] nums) {
        int n = nums.length;
        if(n==0 || n==1){
            return;
        }

        int left = 0;
        int right = 0;
        // loop until size
        while(right < n){
            if(nums[right]==0){
                right++;
            }else{
                int t = nums[left];
                nums[left] = nums[right];
                nums[right] = t;
                left++;
                right++;
            }
        }
    }
}