package leetcode;

public class leet_268 {
	public static void main(String[] args) {

		int max = 0;
		int sum = 0;
		int cnt = 0;

		int[] nums = { 0 };
		for (int n : nums) {
			if (n > max) {
				max = n;
			}

			cnt++;
			sum += n;
		}

		int target = max * (max + 1) / 2;
		int result = target - sum;

		if(max < cnt) {
			System.out.println(cnt);
		}else {
			System.out.println(result);
		}

	}
}
