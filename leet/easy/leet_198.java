class Solution {
    static int[] arr;
    static int[] check;
    static int[] max;
    public int rob(int[] nums) {
        arr = nums;
        check = new int[nums.length];
        max = new int[nums.length];
        return solve(nums.length-1);        
    }
    
   public int solve(int index) {
       
		if (index < 0) {
			return 0;
		}

		if (check[index] != 0) {

		} else {
			max[index] = Math.max(arr[index] + solve(index - 2), solve(index - 1));
		    check[index] = 1;
        }

		return max[index];
	}
}