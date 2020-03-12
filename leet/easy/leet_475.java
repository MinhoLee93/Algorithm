class Solution {
    public int findRadius(int[] houses, int[] heaters) {
       if (houses.length == 0 || heaters.length == 0) {
			return 0;
		}

		int min = Integer.MIN_VALUE;
		// binary search 를 사용하기 위해서는 target array는 sorting이 되어야 한다.
		Arrays.sort(heaters);

		for (int i = 0; i < houses.length; i++) {
			int target = houses[i];
			int pos = Arrays.binarySearch(heaters, target);

			// target does not exist / -(InsertionPoint) -1
			if (pos < 0) {
				// real position
				pos = -pos - 1;
			}

			// house <= target
			if (pos == 0) {
				min = Math.max(min, heaters[0] - target);
			} else if (pos >= heaters.length) {
				// house > target
				min = Math.max(min, target - heaters[heaters.length - 1]);
			} else {
				min = Math.max(min, Math.min(target - heaters[pos - 1], heaters[pos] - target));
			}
		}

		return min;
    }
}