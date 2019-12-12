package leetcode;

import java.util.HashMap;
import java.util.Map;

public class leet_26 {

	public static void main(String[] args) {
		int[] nums = {};
		if(nums==null) {
			//return 0;
		}
		
		int len = 1;

		int base = nums[0];
		int baseIndex = 1;


		
		for (int i = 1; i < nums.length; i++) {
			// 동일하면?
			if (nums[i] == base) {
				continue;
			} else {
				nums[baseIndex++] = nums[i];
				base = nums[i];
				len++;
			}
		}

		System.out.println(len);
	}
}
