package leetcode;

public class leet_35 {

	public static void main(String[] args) {
		int[] nums = {};
		int target = 0;

		for (int i = 0; i < nums.length; i++) {
			if (nums[i] >= target) {
				System.out.println(i);
				break;
			}
		}
		
		System.out.println(nums.length);
	}
}
