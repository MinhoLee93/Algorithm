package samsung;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class N {

	public static int N;
	public static int[][] arr;
	public static Shark shark;
	public static ArrayList<Fish> fishs = new ArrayList<>();

	public static int[] dx = { 1, 0, -1, 0 };
	public static int[] dy = { 0, 1, 0, -1 };

	public static int Result;

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		N = Integer.parseInt(bf.readLine());
		arr = new int[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(bf.readLine());
			for (int j = 0; j < N; j++) {
				int k = Integer.parseInt(st.nextToken());
				arr[i][j] = k;

				if (k == 0) {

				} else if (k == 9) {
					// 상어
					shark = new Shark(i, j, 2, 0);
				} else {

				}
			}
		}
		solve(0);
		System.out.println(Result);
		bf.close();
	}

	public static void solve(int cnt) {

		//System.out.println("solve " + cnt); 
		//System.out.println("상어 크기 : " + shark.size);
		//print();

		// 더이상 잡아 먹을 물고기가 없을 경우
		if (!checkFish()) {
			Result = cnt;
			return;
		}

		Queue<Node> queue = new LinkedList<>();
		queue.add(new Node(shark.x, shark.y, 0));
		// 방문지점 확인
		int[][] check = new int[N][N];
		check[shark.x][shark.y] = 1;

		// 최소지점 찾음
		int minX = N;
		int minY = N;
		int time = Integer.MAX_VALUE;
		while (!queue.isEmpty()) {
			Node temp = queue.poll();

			if (temp.cnt + 1 > time) {
				continue;
			}

			for (int i = 0; i < 4; i++) {
				if (safe(temp.x + dx[i], temp.y + dy[i]) && check[temp.x + dx[i]][temp.y + dy[i]] == 0) {
					// 빈칸
					if (arr[temp.x + dx[i]][temp.y + dy[i]] == 0) {
						Node t1 = new Node(temp.x + dx[i], temp.y + dy[i], temp.cnt + 1);
						queue.add(t1);
						// 방문 기록
						check[temp.x + dx[i]][temp.y + dy[i]] = 1;

						//System.out.println(
						//		"add node : " + (temp.x + dx[i]) + "," + (temp.y + dy[i]) + "," + (temp.cnt + 1));

					} else if (shark.size > arr[temp.x + dx[i]][temp.y + dy[i]]) {

						time = (temp.cnt + 1); // 현재 찾은 시간 기록
						//System.out.println(
						//		"물고기 확인 : " + (temp.x + dx[i]) + " , " + (temp.y + dy[i]) + " , " + (temp.cnt + 1));
						// 방문 기록
						check[temp.x + dx[i]][temp.y + dy[i]] = 1;

						// 가장위
						if ((temp.x + dx[i]) < minX) {
							minX = temp.x + dx[i];
							minY = temp.y + dy[i];

						} else if ((temp.x + dx[i]) == minX) {
							// 가장위가 같은 물고기가 많은 경우
							if (temp.y + dy[i] < minY) {
								minX = temp.x + dx[i];
								minY = temp.y + dy[i];
							}
						}

					} else if (shark.size <= arr[temp.x + dx[i]][temp.y + dy[i]]) {
						// 못먹음
						if (shark.size == arr[temp.x + dx[i]][temp.y + dy[i]]) {
							// 지나갈 순 있음
							Node t2 = new Node(temp.x + dx[i], temp.y + dy[i], temp.cnt + 1);
						//	System.out.println(
						//			"add node : " + (temp.x + dx[i]) + "," + (temp.y + dy[i]) + "," + (temp.cnt + 1));
							queue.add(t2);
							// 방문 기록
							check[temp.x + dx[i]][temp.y + dy[i]] = 1;
						} else {
							// 지나갈 수 도 없음

						}
					}
				}
			}

		}

		// 물고기를 발견했을 경우
		if (minX != N && minY != N) {
			arr[minX][minY] = 9;
			arr[shark.x][shark.y] = 0;

			shark.x = minX;
			shark.y = minY;
			shark.cnt = shark.cnt + 1;

			if (shark.cnt == shark.size) {
				shark.size = shark.size + 1;
				shark.cnt = 0;
			}
			// System.out.println("이동시간 : " + time);

			solve(cnt + time);
		} else {
			Result = cnt;
			return;
		}
	}

	public static class Node {
		int x;
		int y;
		int cnt;

		Node(int x, int y, int cnt) {
			this.x = x;
			this.y = y;
			this.cnt = cnt;
		}
	}

	public static boolean safe(int x, int y) {
		return (x >= 0) && (y >= 0) && (x < N) && (y < N);
	}

	public static void print() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println("------------");
	}

	// 잡아먹을 수 있는 물고기 확인
	public static boolean checkFish() {

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				// 빈칸이 아니면서 && 하나라도 상어보다 사이즈가 작은 물고기가 있을 경우
				if (arr[i][j] != 0 && (shark.size > arr[i][j])) {
					return true;
				}
			}
		}

		return false;
	}

	public static class Shark {
		int x;
		int y;
		int size;
		int cnt;

		Shark(int x, int y, int size, int cnt) {
			this.x = x;
			this.y = y;
			this.size = size;
			this.cnt = cnt;
		}
	}

	public static class Fish {
		int x;
		int y;
		int size;

		Fish(int x, int y, int size) {
			this.x = x;
			this.y = y;
			this.size = size;
		}
	}
}
