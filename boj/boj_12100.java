package samsung;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Easy {
	static int[][] base;
	static int N;
	static int MAX = 0;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		N = Integer.parseInt(bf.readLine());
		base = new int[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(bf.readLine());
			for (int j = 0; j < N; j++) {
				base[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		go(base, 1, 1);
		go(base, 1, 2);
		go(base, 1, 3);
		go(base, 1, 4);

		System.out.println(MAX);
		bf.close();
	}

	public static int[][] copy(int[][] arr) {
		int[][] temp = new int[N][N];

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				temp[i][j] = Math.abs(arr[i][j]);
			}
		}

		return temp;
	}

	// 1: 오 , 2:왼 , 3: 위, 4: 아래
	public static void go(int[][] arr, int cnt, int flag) {
		// System.out.println("go(" + cnt + " , " + flag + " ) ");

		// 최대블럭 확인
		find(arr);

		// 최대 5
		if (cnt > 5) {
			return;
		}

		switch (flag) {
		case 1:
			int[][] t1 = left(left(arr));
			solve(t1);
			t1 = right(right(t1));

//			System.out.println("오");
//			print(t1);

			go(t1, cnt + 1, 2);
			go(t1, cnt + 1, 3);
			go(t1, cnt + 1, 4);
			break;
		case 2:
			int[][] t2 = copy(arr);
			solve(t2);
//			System.out.println("왼");
			t2 = copy(t2);
//			print(t2);

			go(t2, cnt + 1, 1);
			go(t2, cnt + 1, 3);
			go(t2, cnt + 1, 4);
			break;
		case 3:
			int[][] t3 = left(arr);
			solve(t3);
			t3 = right(t3);
//			System.out.println("위");
//			print(t3);

			go(t3, cnt + 1, 1);
			go(t3, cnt + 1, 2);
			go(t3, cnt + 1, 4);
			break;
		case 4:
			int[][] t4 = right(arr);
			solve(t4);
			t4 = left(t4);
//			System.out.println("아래");
//			print(t4);

			go(t4, cnt + 1, 1);
			go(t4, cnt + 1, 2);
			go(t4, cnt + 1, 3);
			break;
		}
	}

	public static void find(int[][] arr) {
		int temp = 0;

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (Math.abs(arr[i][j]) > temp) {
					temp = Math.abs(arr[i][j]);
				}
			}
		}

		if (temp > MAX) {
			MAX = temp;
		}

	}

	public static void solve(int[][] arr) {

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (arr[i][j] == 0) {
					continue;
				}
				// print(arr);
				for (int k = 1; (j - k) >= 0; k++) {
					// System.out.println("i :" + i + " , j : " + j + " , k: " + k);

					if (safe(j - k)) {
						// 빈칸일때
						if (arr[i][j - k] == 0) {
							// System.out.println("빈칸");
							arr[i][j - k] = arr[i][j];
							arr[i][j] = 0;

							j = j - k;
							k = 0;
						} else if (arr[i][j - k] == arr[i][j]) {
							// 같은 숫자일때
							// System.out.println("합치기");
							arr[i][j - k] = arr[i][j - k] * (-2);
							arr[i][j] = 0;
						} else {
							break;
						}
					}
				}
			}
		}
	}

	public static boolean safe(int y) {
		return (y >= 0) && (y < N);
	}

	public boolean check(int[][] old, int[][] renew) {

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				// 하나라도 다르면 return;
				if (old[i][j] != renew[i][j]) {
					return false;
				}
			}
		}

		// 동일하다, 멈춘다.
		return true;

	}

	public static int[][] left(int[][] arr) {
		int[][] temp = new int[N][N];

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				temp[i][j] = Math.abs(arr[j][(N - 1) - i]);
			}
		}

		return temp;
	}

	public static int[][] right(int[][] arr) {
		int[][] temp = new int[N][N];

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				temp[i][j] = Math.abs(arr[(N - 1) - j][i]);
			}
		}

		return temp;
	}

	public static void print(int[][] arr) {

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println("--------");
	}
}
