package leetcode;

public class leet_1266 {

	public static void main(String[] args) {
		int[][] arr = { { 1, 1 }, { 3, 4 }, { -1, 0 } };

		int result = 0;
		for (int i = 1; i < arr.length; i++) {
			int x = Math.abs(arr[i][0] - arr[i - 1][0]);
			int y = Math.abs(arr[i][1] - arr[i - 1][1]);

			if (x > y) {
				result += x;
			} else {
				result += y;
			}
		}

		System.out.println(result);
	}
}
