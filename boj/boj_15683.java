package samsung;

import java.awt.List;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class N {
	static int N;
	static int M;
	static int[][] arr;
	static ArrayList<Node> cctv = new ArrayList<Node>();
	static int MIN = Integer.MAX_VALUE;

	public static void main(String[] args) throws IOException {

		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(bf.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N][M];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(bf.readLine());
			for (int j = 0; j < M; j++) {
				int x = Integer.parseInt(st.nextToken());
				if (1 <= x && x <= 5) {
					// cctv add
					Node n = new Node(i, j);
					cctv.add(n);
				}
				// arr
				arr[i][j] = x;
			}
		}

		solve(arr, 0);
		System.out.println(MIN);
		bf.close();

	}

	static int check(int[][] arr) {

		int temp = 0;

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (arr[i][j] == 0) {
					temp++;
				}
			}
		}

		return temp;
	}

	static void solve(int[][] arr, int index) {
		//printArr(arr);
		//System.out.println("--------------");

		if (index >= cctv.size()) {
			// MIN check
			int result = check(arr);
			if (result < MIN) {
				MIN = result;
			}

			return;
		}

		Node ne = cctv.get(index);
		int x = ne.x;
		int y = ne.y;
		switch (arr[x][y]) {
		case 1:
			solve(right(copy(arr), x, y), index + 1);
			solve(down(copy(arr), x, y), index + 1);
			solve(left(copy(arr), x, y), index + 1);
			solve(up(copy(arr), x, y), index + 1);
			break;
		case 2:
			solve(left(right(copy(arr), x, y), x, y), index + 1);
			solve(down(up(copy(arr), x, y), x, y), index + 1);
			break;
		case 3:
			solve(up(right(copy(arr), x, y), x, y), index + 1);
			solve(right(down(copy(arr), x, y), x, y), index + 1);
			solve(down(left(copy(arr), x, y), x, y), index + 1);
			solve(left(up(copy(arr), x, y), x, y), index + 1);
			break;
		case 4:
			solve(left(up(right(copy(arr), x, y), x, y), x, y), index + 1);
			solve(up(right(down(copy(arr), x, y), x, y), x, y), index + 1);
			solve(right(down(left(copy(arr), x, y), x, y), x, y), index + 1);
			solve(down(left(up(copy(arr), x, y), x, y), x, y), index + 1);
			break;
		case 5:
			solve(left(up(down(right(copy(arr), x, y), x, y), x, y), x, y), index + 1);
			break;
		}

	}

	static int[][] copy(int[][] arr) {
		int[][] temp = new int[N][M];

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				temp[i][j] = arr[i][j];
			}
		}

		return temp;
	}

	static boolean safe(int x, int y) {
		return (x >= 0) && (y >= 0) && (x < N) && (y < M);
	}

	static int[][] right(int[][] arr, int x, int y) {

		int index = 1;
		while (safe(x, y + index)) {
			// 벽일때
			if (arr[x][y + index] == 6) {
				return arr;
				// 빈곳일때
			} else if (arr[x][y + index] == 0) {
				arr[x][y + index] = 7;

			} else {

			}
			index++;
		}

		return arr;
	}

	static int[][] left(int[][] arr, int x, int y) {

		int index = 1;
		while (safe(x, y - index)) {
			// 벽일때
			if (arr[x][y - index] == 6) {
				return arr;
				// 빈곳일때
			} else if (arr[x][y - index] == 0) {
				arr[x][y - index] = 7;

			} else {

			}
			index++;
		}

		return arr;
	}

	static int[][] up(int[][] arr, int x, int y) {

		int index = 1;
		while (safe(x - index, y)) {
			// 벽일때
			if (arr[x - index][y] == 6) {
				return arr;
				// 빈곳일때
			} else if (arr[x - index][y] == 0) {
				arr[x - index][y] = 7;

			} else {

			}
			index++;
		}

		return arr;
	}

	static int[][] down(int[][] arr, int x, int y) {

		int index = 1;
		while (safe(x + index, y)) {
			// 벽일때
			if (arr[x + index][y] == 6) {
				return arr;
				// 빈곳일때
			} else if (arr[x + index][y] == 0) {
				arr[x + index][y] = 7;

			} else {

			}
			index++;
		}

		return arr;
	}

	static void printArr(int[][] arr) {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
	}

	static class Node {
		int x;
		int y;

		Node(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
}
