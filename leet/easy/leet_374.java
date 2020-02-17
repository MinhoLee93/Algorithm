package leetcode;

public class leet_374 {
	static int pick;

	public static void main(String[] args) {
		int n = 2126753390;
		pick = 1702766719;
		System.out.println("result : " + guessNumber(n));
	}

	public static int guessNumber(int n) {
		long start = 1;
		long end = n;
		int result = 0;
		
		while (start <= end) {
			System.out.println("start : " + start + " , end :" + end);
			long c = (start + end) / 2;
			int temp = guess((int) c);
			if (temp == -1) {
				end = c - 1;
			} else if (temp == 1) {
				start = c + 1;
			} else {
				return (int) c;
			}
		}
		
		return 0;
	}

	public static int guess(int num) {
		if (num > pick) {
			return -1;
		} else if (num < pick) {
			return 1;
		} else {
			return 0;
		}
	}
}
