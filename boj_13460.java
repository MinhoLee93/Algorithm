package samsung;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N2 {
	static int N;
	static int M;
	static char[][] arr;
	static int[][][][][] check;
	static int MIN = Integer.MAX_VALUE;

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(bf.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new char[N][M];
		check = new int[11][N][M][N][M];

		for (int i = 0; i < N; i++) {
			String s = bf.readLine();
			char[] c = s.toCharArray();
			for (int j = 0; j < M; j++) {
				arr[i][j] = c[j];
			}
		}

		solve(arr, 1, 1);
		solve(arr, 1, 2);
		solve(arr, 1, 3);
		solve(arr, 1, 4);

		if (MIN == Integer.MAX_VALUE) {
			System.out.println(-1);
		} else {
			System.out.println(MIN);
		}

		bf.close();
	}

	public static boolean safe(int x, int y) {
		return (x >= 0) && (x < N) && (y >= 0) && (y < M);
	}

	public static int go(char[][] arr) {

		int n = arr.length;
		int m = arr[0].length;

		// 빨간공 파란공 구멍
		boolean blue = false;
		boolean red = false;

		for (int i = 1; i < n - 1; i++) {
			for (int j = 1; j < m - 1; j++) {
				if (arr[i][j] == 'B') {
					for (int k = 1; (j - k) >= 1; k++) {
						if (arr[i][j - k] == 'O') {
							arr[i][j] = '.';
							blue = true;
							break;
						} else if (arr[i][j - k] == '.') {
							arr[i][j - k] = 'B';
							arr[i][j] = '.';
							j = j - k;
							k = 0;

						} else {

							break;
						}
					}
				} else if (arr[i][j] == 'R') {
					for (int k = 1; (j - k) >= 1; k++) {
						if (arr[i][j - k] == 'O') {
							arr[i][j] = '.';
							red = true;
							break;
						} else if (arr[i][j - k] == '.') {
							arr[i][j - k] = 'R';
							arr[i][j] = '.';
							j = j - k;
							k = 0;

						} else {
							break;
						}
					}
				} else {
					continue;
				}
			}
		}

		// 둘다 구멍에 빠지면 false
		if (blue && red) {
			return 2;
		} else if (red && !blue) {
			return 1;
		} else if (blue) {
			return 2;
		} else {
			return 0;
		}

	}

	// 빨,파란공 위치 중복 체크
	public static boolean check(char[][] arr, int cnt) {

		int bx = 0;
		int by = 0;
		int rx = 0;
		int ry = 0;

		boolean blue = false;
		boolean red = false;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (arr[i][j] == 'B') {
					bx = i;
					by = j;
					blue = true;
				} else if (arr[i][j] == 'R') {
					rx = i;
					ry = j;
					red = true;
				}

				if (blue && red) {
					if (check[cnt][bx][by][rx][ry] == 0) {
						check[cnt][bx][by][rx][ry] = 1;
						return true;
					} else {
						return false;
					}
				}
			}
		}

		return false;
	}

	// 왼/오/아래/위
	public static void solve(char[][] arr, int cnt, int flag) {
		//System.out.println("cnt : " + cnt);

		if (cnt > MIN) {
			return;
		}

		if (cnt > 10) {
			return;
		}

		switch (flag) {
		// 왼
		case 1:
			//System.out.println("왼");
			char[][] t1 = copy(arr);
			int r1 = go(t1);

			//print(t1);

			if (r1 == 0) {
				if (check(t1, cnt)) {
					// 진행
					solve(t1, cnt + 1, 2);
					solve(t1, cnt + 1, 3);
					solve(t1, cnt + 1, 4);
				} else {
					return;
				}
			} else if (r1 == 1) {
				// 성공
				if (cnt < MIN) {
					MIN = cnt;
				}
				return;
			} else if (r1 == 2) {
				// 실패 && 똒같은 위치
				return;
			}

			break;
		// 오
		case 2:
			//System.out.println("오");
			char[][] t2 = left(left(arr));
			int r2 = go(t2);
			t2 = right(right(t2));
			//print(t2);

			if (r2 == 0) {

				if (check(t2, cnt)) {
					// 진행
					solve(t2, cnt + 1, 1);
					solve(t2, cnt + 1, 3);
					solve(t2, cnt + 1, 4);
				} else {
					return;
				}
			} else if (r2 == 1) {
				// 성공
				if (cnt < MIN) {
					MIN = cnt;
				}
				return;
			} else if (r2 == 2) {
				// 실패 && 똒같은 위치
				return;
			}

			break;
		// 아래
		case 3:
			//System.out.println("아래");
			char[][] t3 = right(arr);
			int r3 = go(t3);
			t3 = left(t3);
			//print(t3);

			if (r3 == 0) {
				if (check(t3, cnt)) {
					// 진행
					solve(t3, cnt + 1, 1);
					solve(t3, cnt + 1, 2);
					solve(t3, cnt + 1, 4);
				} else {
					return;
				}
			} else if (r3 == 1) {
				// 성공
				if (cnt < MIN) {
					MIN = cnt;
				}
				return;
			} else if (r3 == 2) {
				// 실패 && 똒같은 위치
				return;
			}

			break;
		// 위
		case 4:
			//System.out.println("위");
			char[][] t4 = left(arr);
			int r4 = go(t4);
			t4 = right(t4);
			//print(t4);

			if (r4 == 0) {
				if (check(t4, cnt)) {
					// 진행
					solve(t4, cnt + 1, 1);
					solve(t4, cnt + 1, 2);
					solve(t4, cnt + 1, 3);
				} else {
					return;
				}

			} else if (r4 == 1) {
				// 성공
				if (cnt < MIN) {
					MIN = cnt;
				}
				return;
			} else if (r4 == 2) {
				// 실패 && 똒같은 위치
				return;
			}

			break;
		}
	}

	public static char[][] copy(char[][] arr) {
		int n = arr.length;
		int m = arr[0].length;

		char[][] temp = new char[n][m];

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				temp[i][j] = arr[i][j];
			}
		}

		return temp;
	}

	public static char[][] right(char[][] arr) {
		int n = arr.length;
		int m = arr[0].length;

		char[][] temp = new char[m][n];

		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				temp[i][j] = arr[(n - 1) - j][i];
			}
		}

		return temp;
	}

	public static char[][] left(char[][] arr) {
		int n = arr.length;
		int m = arr[0].length;

		char[][] temp = new char[m][n];

		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				temp[i][j] = arr[j][(m - 1) - i];
			}
		}

		return temp;
	}

	public static void print(char[][] arr) {
		int n = arr.length;
		int m = arr[0].length;

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
	}
}
