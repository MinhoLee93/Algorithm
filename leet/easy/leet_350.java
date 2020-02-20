class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        Map<Integer, Integer> hash = new HashMap<>();
		List<Integer> list = new ArrayList<>();
		for (int i : nums1) {
			if (hash.containsKey(i)) {
				hash.replace(i, hash.get(i) + 1);
			} else {
				hash.put(i, 1);
			}
		}

		for (int i : nums2) {
			if (hash.containsKey(i)) {
				list.add(i);
				hash.replace(i, hash.get(i) - 1);
				if (hash.get(i) == 0) {
					hash.remove(i);
				}
			}
		}
		
		int[] result = new int[list.size()];
		int index = 0;
		for (int i : list) {
			result[index++] = i;
		}
        
        return result;
    }
}