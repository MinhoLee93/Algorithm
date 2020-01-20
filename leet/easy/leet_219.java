class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        if(nums==null || nums.length==0){
            return false;
        }
        
        boolean result = false;
		// value, index
		Map<Integer, Integer> hash = new HashMap<>();
		for (int i = 0; i < nums.length; i++) {
			if (hash.containsKey(nums[i])) {
				if (i - hash.get(nums[i]) <= k) {
					result = true;
					break;
				} else {
					hash.put(nums[i], i);
				}
			} else {
				hash.put(nums[i], i);
			}
		}
        
        return result;
    }
}