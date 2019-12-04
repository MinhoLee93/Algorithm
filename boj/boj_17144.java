package samsung;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N1 {

	static int R;
	static int C;
	static int T;

	static int[][] arr;
	static int Result;

	static int[] dx = { 1, 0, -1, 0 };
	static int[] dy = { 0, 1, 0, -1 };

	static int upIndex;
	static int downIndex;

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(bf.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		T = Integer.parseInt(st.nextToken());

		arr = new int[R][C];
		boolean up = false;

		for (int i = 0; i < R; i++) {
			st = new StringTokenizer(bf.readLine());
			for (int j = 0; j < C; j++) {
				int k = Integer.parseInt(st.nextToken());
				arr[i][j] = k;

				if (k == -1) {
					if (!up) {
						upIndex = i;
						downIndex = i + 1;
						up = true;
					}
				}
			}
		}

		solve(0);
		System.out.println(Result);
		bf.close();
	}

	public static void solve(int cnt) {

		//print();
		if (cnt == T) {
			Result = check();
			return;
		}

		int[][] young = new int[R][C];

		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				int c = 0;
				for (int k = 0; k < 4; k++) {
					if (safe(i + dx[k], j + dy[k]) && arr[i + dx[k]][j + dy[k]] != -1) {
						young[i + dx[k]][j + dy[k]] += (arr[i][j] / 5);
						c++;
					}
				}

				arr[i][j] = arr[i][j] - (arr[i][j] / 5) * c;
			}
		}

		merge(arr, young);
		arr = clear(arr);
		solve(cnt + 1);
	}


	public static int[][] clear(int[][] arr) {
		int[][] temp = new int[R][C];

		temp[upIndex][1] = 0;
		temp[downIndex][1] = 0;
		for (int j = 2; j < C; j++) {
			temp[upIndex][j] = arr[upIndex][j - 1];
			temp[downIndex][j] = arr[downIndex][j - 1];
		}

		for (int j = 0; j <= C - 2; j++) {
			temp[0][j] = arr[0][j + 1];
			temp[R - 1][j] = arr[R - 1][j + 1];
		}

		for (int i = upIndex - 1; i >= 1; i--) {
			temp[i][0] = arr[i - 1][0];
		}

		for (int i = downIndex + 1; i <= R - 2; i++) {
			temp[i][0] = arr[i + 1][0];
		}

		for (int i = 0; i < upIndex; i++) {
			temp[i][C - 1] = arr[i + 1][C - 1];
		}

		for (int i = R - 1; i > downIndex; i--) {
			temp[i][C - 1] = arr[i - 1][C - 1];
		}

		for (int i = 1; i < R - 1; i++) {
			for (int j = 1; j < C - 1; j++) {
				if (i != upIndex && i != downIndex) {
					temp[i][j] = arr[i][j];
				}
			}
		}

		return temp;
	}

	public static void merge(int[][] old, int[][] young) {

		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				old[i][j] = old[i][j] + young[i][j];
			}
		}
	}

	public static int check() {
		int temp = 0;

		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if (arr[i][j] != -1) {
					temp += arr[i][j];
				}
			}
		}

		return temp;
	}

	public static boolean safe(int x, int y) {
		return (x >= 0) && (y >= 0) && (x < R) && (y < C);
	}

	public static void print() {
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println("--------------------");
	}
}
