package samsung;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N1 {
	static int L;
	static int R;

	static int N;
	static int[][] arr;
	static int[][] check;

	static int[] dx = { 1, 0, -1, 0 };
	static int[] dy = { 0, 1, 0, -1 };

	static int uIndex = 0;
	static int[] people;
	static int[] union;

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(bf.readLine());
		N = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());

		arr = new int[N][N];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(bf.readLine());
			for (int j = 0; j < N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		int cnt = 0;
		while (true) {
			check = new int[N][N];
			people = new int[N * N + 1];
			union = new int[N * N + 1];
			uIndex = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (check[i][j] == 0) {
						uIndex++;
						solve(i, j);
					}
				}
			}
			// 인구이동 일어남
			if (uIndex < N * N) {
				spread(arr);
				//print(arr);
				cnt++;
			} else {
				break;
			}
		}
		System.out.println(cnt);
		bf.close();
	}

	static void spread(int[][] arr) {

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				arr[i][j] = (people[check[i][j]] / union[check[i][j]]);
			}
		}
	}

	static boolean safe(int x, int y) {
		return (x >= 0) && (y >= 0) && (x < N) && (y < N);
	}

	static void solve(int x, int y) {
		check[x][y] = uIndex;
		people[uIndex] += arr[x][y];
		union[uIndex]++;
		//print(check);
		//printPeople(people);

		for (int i = 0; i < 4; i++) {
			if (safe(x + dx[i], y + dy[i]) && check[x + dx[i]][y + dy[i]] == 0) {
				int from = arr[x][y];
				int to = arr[x + dx[i]][y + dy[i]];
				//System.out.println("from : " + from);
				//System.out.println("to : " + to);

				if (Math.abs(from - to) >= L && Math.abs(from - to) <= R) {
					//System.out.println("WEF");
					solve(x + dx[i], y + dy[i]);
				}
			}
		}
	}

	static void printPeople(int[] arr) {
		for (int i = 1; i <= N * N; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}

	static void print(int[][] arr) {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println("-------------");
	}
}
