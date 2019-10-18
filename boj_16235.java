package samsung;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Tree {

	static int N;
	static int K;
	static int M;
	static int[][] arr;
	static int[][] base;
	static int Result;
	static LinkedList<tree> trees = new LinkedList<tree>();
	static int[] dx = { -1, -1, -1, 0, 0, 1, 1, 1 };
	static int[] dy = { -1, 0, 1, -1, 1, -1, 0, 1 };

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(bf.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		arr = new int[N][N];
		base = new int[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(bf.readLine());
			for (int j = 0; j < N; j++) {
				int k = Integer.parseInt(st.nextToken());
				arr[i][j] = 5;
				base[i][j] = k;
			}
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(bf.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int z = Integer.parseInt(st.nextToken());

			tree t = new tree(x - 1, y - 1, z);
			trees.add(t);
		}

		solve(0);
		System.out.println(trees.size());
		bf.close();
	}

	public static void solve(int cnt) {

		//System.out.println("size: " + trees.size());
		if (cnt == K) {
			return;
		}

		if (trees.size() == 0) {
			return;
		}

		//print();

		// 봄
		spring();
		// 여름
		summer();
		// 가을
		fall();
		// 겨울
		winter();

		solve(cnt + 1);
	}

	public static void spring() {

		Iterator<tree> iter = trees.iterator();
		// 어린나무부터 양분 먹기
		while (iter.hasNext()) {
			tree t = iter.next();
			// 자신의 나이만큼 양분 먹기
			if (arr[t.x][t.y] >= t.z) {
				// System.out.println(t.x + "," + t.y + " 양분먹기 ");
				arr[t.x][t.y] = arr[t.x][t.y] - t.z;
				t.z = t.z + 1;
			} else {
				t.alive = false;

			}
		}
	}

	public static void summer() {
		Iterator<tree> iter = trees.iterator();
		// 어린나무부터 양분 먹기
		while (iter.hasNext()) {
			tree t = iter.next();
			if (!t.alive) {
				// 나무 -> 양분
				arr[t.x][t.y] = arr[t.x][t.y] + (t.z / 2);
				// System.out.println(t.x + "," + t.y + " 나무제거 ");
				// 양분이 없다면 해당 나무 제거
				iter.remove();
			}
		}
	}

	public static void fall() {

		LinkedList<tree> young = new LinkedList<tree>();
		// 나무 번식
		for (tree t : trees) {
			// 나무의 나이가 5의 배수라면?
			if (t.z % 5 == 0) {
				for (int j = 0; j < 8; j++) {
					if (safe(t.x + dx[j], t.y + dy[j])) {
						// System.out.println(t.x + "," + t.y + " 번식 ");
						tree ne = new tree(t.x + dx[j], t.y + dy[j], 1);
						young.add(ne);
					}
				}
			}
		}

		trees.addAll(0, young);
	}

	public static void winter() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				arr[i][j] = arr[i][j] + base[i][j];
			}
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
		System.out.println("--------------");
	}

	public static class tree {
		int x;
		int y;
		int z;
		boolean alive;

		tree(int x, int y, int z) {
			this.x = x;
			this.y = y;
			this.z = z;
			this.alive = true;
		}
	}
}
