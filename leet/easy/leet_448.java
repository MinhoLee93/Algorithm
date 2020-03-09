class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {           
        int[] check = new int[nums.length + 1];

		for (int i = 0; i < nums.length; i++) {
			check[nums[i]] = 1;
		}

		List<Integer> result = new ArrayList<>();
		for (int i = 1; i <= nums.length; i++) {
			if(check[i]==0) {
				result.add(i);
			}
		}
		
		return result;
    }
}