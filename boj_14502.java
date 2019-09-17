package samsung;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class boj_14502 {
	static int[] dx = { 1, 0, -1, 0 };
	static int[] dy = { 0, 1, 0, -1 };
	static int Max = 0;

	static int N;
	static int M;
	static int[][] arr;
	static List<Node> node = new ArrayList<Node>();

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
				arr[i][j] = Integer.parseInt(st.nextToken());
				// 기존 바이러스 있는곳 기억
				if (arr[i][j] == 2) {
					node.add(new Node(i, j));
				}
			}
		}

		// 벽 세우기
		makeWall(0, 0, 0);
		System.out.println(Max);
	}

	static class Node {
		int x;
		int y;

		Node(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	static boolean safe(int x, int y) {
		return (x >= 0) && (y >= 0) && (x < N) && (y < M);
	}

	static void makeWall(int x, int y, int cnt) {

		if (cnt == 3) {
			int[][] makedWall = copy(arr);

			int xx = 0;
			int yy = 0;

			// 바이러스 있는곳 -> 퍼트리기
			for (Node n : node) {
				xx = n.x;
				yy = n.y;

				spreadVirus(xx, yy, makedWall);
			}

			int temp = checkNoVirus(makedWall);
			if (temp > Max) {
				Max = temp;
				//printArr(makedWall);
			}
			
			return;
		}

		for (int i = x; i < N; i++) {
			for (int j = y; j < M; j++) {
				if (arr[i][j] == 0) {
					arr[i][j] = 1;
					makeWall(i, j, cnt + 1);
					arr[i][j] = 0;
				}
			}
			y = 0;
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

	static void spreadVirus(int x, int y, int[][] arr) {
		// printArr(arr);

		for (int i = 0; i < 4; i++) {
			if (safe(x + dx[i], y + dy[i]) && arr[x + dx[i]][y + dy[i]] == 0) {
				arr[x + dx[i]][y + dy[i]] = 2;
				spreadVirus(x+dx[i], y+dy[i], arr);
			}
		}

	}

	static void printArr(int[][] arr) {

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println("------------------");
	}

	// 안전영역 갯수 구하기
	static int checkNoVirus(int[][] arr) {
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

	// 벽세우기

	// 바이러스 퍼트리기
}
