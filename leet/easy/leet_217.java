package leetcode;

import java.util.HashMap;
import java.util.Map;

public class leet_217 {

	public static void main(String[] args) {
		int[] nums = { 1, 2, 3, 1 };
		Map<Integer, Integer> hash = new HashMap<>();

		for (int n : nums) {
			if (hash.containsKey(n)) {

			} else {
				hash.put(n, 1);
			}
		}
	}
}
