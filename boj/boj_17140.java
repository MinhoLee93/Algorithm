package samsung;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class N1 {

	static int r;
	static int c;
	static int k;

	// 행
	static int xIndex = 3;
	// 열
	static int yIndex = 3;

	static int[][] arr = new int[100][100];
	static int Result;

	public static void main(String[] args) throws IOException {

		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(bf.readLine());
		r = (Integer.parseInt(st.nextToken()) - 1);
		c = (Integer.parseInt(st.nextToken()) - 1);
		k = Integer.parseInt(st.nextToken());

		for (int i = 0; i < 3; i++) {
			st = new StringTokenizer(bf.readLine());
			for (int j = 0; j < 3; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		// print(arr);
		solve(0, arr);
		System.out.println(Result);
		bf.close();
	}

	static void solve(int cnt, int[][] arr) {

		if (arr[r][c] == k) {
			Result = cnt;
			return;
		}

		if (cnt > 100) {
			Result = -1;
			return;
		}

		// 행의 갯수 >= 열의 갯수
		if (xIndex >= yIndex) {
			// 오른쪽 방향
			//System.out.println("R연산");
			int[][] r = RSolve(arr);
			solve(cnt + 1, r);
		} else {
			// 행의 갯수 < 열의갯수
			//System.out.println("C연산");
			int[][] c = CSolve(arr);
			// 아래방향
			solve(cnt + 1, c);
		}

	}

	static int[][] copy(int[][] arr) {
		int[][] temp = new int[100][100];

		for (int i = 0; i < 100; i++) {
			for (int j = 0; j < 100; j++) {
				temp[i][j] = arr[i][j];
			}
		}

		return temp;
	}

	// 1: r / 2: c
	static int[][] RSolve(int[][] arr) {
		//print(arr);

		int[][] temp = new int[100][100];
		int max = 0;
		for (int i = 0; i < xIndex; i++) {
			//System.out.println("row : " + i);
			// 새로운 arr index
			int index = 0;

			Map<Integer, Integer> map = new HashMap<>();
			// 카운트 하고
			for (int j = 0; j < yIndex; j++) {
				// 숫자
				int t = arr[i][j];
				// 이미 있다면?
				if (t != 0) {
					if (map.containsKey(t)) {
						map.replace(t, map.get(t) + 1);
					} else {
						map.put(t, 1);
					}
				}
			}

			ArrayList<Node> n = new ArrayList<Node>();
			for (int s : map.keySet()) {
				int key = s;
				int value = map.get(s);

				Node ne = new Node(key, value);
				n.add(ne);
			}

			Collections.sort(n);
			for (Node sorted : n) {
				// 100을 넘어가면 버린다
				if (index >= 100) {
					break;
				}
				temp[i][index++] = sorted.x;
				temp[i][index++] = sorted.y;

				//System.out.println("Index : " + index);
				// 최대 max 체크
				if (index > max) {
					max = index;
				}
			}
		}

		yIndex = max;

		return temp;
	}

	static int[][] CSolve(int[][] arr) {
		//print(arr);

		int[][] temp = new int[100][100];
		int max = 0;
		for (int i = 0; i < yIndex; i++) {
			//System.out.println("row : " + i);
			// 새로운 arr index
			int index = 0;

			Map<Integer, Integer> map = new HashMap<>();
			// 카운트 하고
			for (int j = 0; j < xIndex; j++) {
				// 숫자
				int t = arr[j][i];
				// 이미 있다면?
				if (t != 0) {
					if (map.containsKey(t)) {
						map.replace(t, map.get(t) + 1);
					} else {
						map.put(t, 1);
					}
				}
			}

			ArrayList<Node> n = new ArrayList<Node>();
			for (int s : map.keySet()) {
				int key = s;
				int value = map.get(s);

				Node ne = new Node(key, value);
				n.add(ne);
			}

			Collections.sort(n);
			for (Node sorted : n) {
				// 100을 넘어가면 버린다
				if (index >= 100) {
					break;
				}
				temp[index++][i] = sorted.x;
				temp[index++][i] = sorted.y;

				//System.out.println("Index : " + index);
				// 최대 max 체크
				if (index > max) {
					max = index;
				}
			}
		}

		xIndex = max;

		return temp;
	}

	static boolean safe(int x, int y) {
		return (x >= 0) && (y >= 0) && (x < 100) && (y < 100);
	}

	static class Node implements Comparable<Node> {
		// 숫자
		public int x;
		// 카운트
		public int y;

		Node(int x, int y) {
			this.x = x;
			this.y = y;
		}

		@Override
		public int compareTo(Node o) {
			if (this.y > o.y) {
				return 1;
			} else if (this.y == o.y) {
				if (this.x > o.x) {
					return 1;
				} else {
					return -1;
				}
			} else {
				return -1;
			}

		}
	}

	static int[][] left(int[][] arr) {

		int[][] temp = new int[100][100];

		for (int i = 0; i < arr[0].length; i++) {
			for (int j = 0; j < arr.length; j++) {
				temp[i][j] = arr[j][(arr[0].length - 1) - i];
			}
		}

		return temp;
	}

	static int[][] right(int[][] arr) {

		int[][] temp = new int[100][100];

		for (int i = 0; i < arr[0].length; i++) {
			for (int j = 0; j < arr.length; j++) {
				temp[i][j] = arr[(arr.length - 1) - j][i];
			}
		}

		return temp;
	}

	static void print(int[][] arr) {

		for (int i = 0; i < xIndex; i++) {
			for (int j = 0; j < yIndex; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println("--------------");
	}
}
