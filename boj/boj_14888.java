package samsung;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S1 {
	static long MAX = Long.MIN_VALUE;
	static long MIN = Long.MAX_VALUE;

	static int N;
	static int[] arr;

	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		N = Integer.parseInt(bf.readLine());
		st = new StringTokenizer(bf.readLine());
		arr = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		st = new StringTokenizer(bf.readLine());
		int plus = Integer.parseInt(st.nextToken());
		int minus = Integer.parseInt(st.nextToken());
		int multiple = Integer.parseInt(st.nextToken());
		int divide = Integer.parseInt(st.nextToken());

		solve(arr[0], 1, plus, minus, multiple, divide);
		System.out.println(MAX);
		System.out.println(MIN);
		bf.close();
	}

	static void solve(int sum, int index, int plus, int minus, int multiple, int divide) {

		if (index == N) {
			if (sum > MAX) {
				MAX = sum;
			}

			if (sum < MIN) {
				MIN = sum;
			}

			return;
		}

		if (plus > 0) {
			solve(sum + arr[index], index + 1, plus - 1, minus, multiple, divide);
		}

		if (minus > 0) {
			solve(sum - arr[index], index + 1, plus, minus - 1, multiple, divide);
		}

		if (multiple > 0) {
			solve(sum * arr[index], index + 1, plus, minus, multiple - 1, divide);
		}

		if (divide > 0) {
			if (sum < 0) {
				solve(-((-sum) / arr[index]), index + 1, plus, minus, multiple, divide - 1);
			} else {
				solve(sum / arr[index], index + 1, plus, minus, multiple, divide - 1);
			}
		}
	}
}
