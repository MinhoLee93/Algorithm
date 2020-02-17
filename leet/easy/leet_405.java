package leetcode;

public class leet_405 {
	static long[] arr = new long[32];
	static String[] hex = { "a", "b", "c", "d", "e", "f" };

	public static void main(String[] args) {
		int num = -2147483648;
		if (num >= 0) {
			solvePlus(num);
		} else {
			solveMinus(num);
		}

		System.out.println(getHex(arr));
	}

	static void solvePlus(int num) {
		int base = num;
		int index = arr.length - 1;
		while (base != 0) {
			// System.out.println("ss" + base % 16);
			arr[index--] = base % 16;
			base = base / 16;
		}
	}

	static void solveMinus(int num) {
		long base = -num;
		int index = arr.length - 1;
		while (base != 0) {
			arr[index--] = base % 2;
			base = base / 2;
		}

		for (int i = 0; i < arr.length; i++) {
			arr[i] = 1 - arr[i];
		}
		arr[arr.length - 1]++;
		increment(arr);
		print(arr);
			
		arr = getSum(arr);
		print(arr);
	}

	static void increment(long[] arr) {
		for (int i = arr.length - 1; i >= 0; i--) {
			if (arr[i] >= 2) {
				arr[i] = arr[i] - 2;
				
				if(i!=0) {
					arr[i - 1] = arr[i - 1] + 1;
				}
			}
		}
	}

	public static void print(long[] arr) {
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}

	public static long[] getSum(long[] arr) {
		long[] sum = new long[arr.length / 4];
		int index = 0;
		for (int i = 0; i < arr.length; i = i + 4) {
			sum[index++] += arr[i] * Math.pow(2, 3) + arr[i + 1] * Math.pow(2, 2) + arr[i + 2] * Math.pow(2, 1)
					+ arr[i + 3] * Math.pow(2, 0);
		}
		return sum;
	}

	public static String getHex(long[] arr) {
		StringBuilder sb = new StringBuilder();

		boolean check = false;
		for (int i = 0; i < arr.length; i++) {
			if ((!check && arr[i] != 0) || check) {
				check = true;
				if (arr[i] >= 10) {
					sb.append(hex[(int) (arr[i] - 10)]);
				} else {
					sb.append(arr[i]);
				}
			}
		}

		return sb.toString();
	}
}
