package samsung;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class N2 {

	static int N;
	static int M;
	static int[][] arr;
	static int[] dx = { 1, 0, -1, 0 };
	static int[] dy = { 0, 1, 0, -1 };
	static int Result;

	static Virus[] virus;
	static int vIndex;

	static Virus[] selected;
	static int sIndex;

	static int MIN = Integer.MAX_VALUE;

	static int zeroCnt;

	public static void main(String[] args) throws IOException {

		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(bf.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		arr = new int[N][N];
		virus = new Virus[10];
		selected = new Virus[M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(bf.readLine());
			for (int j = 0; j < N; j++) {
				int k = Integer.parseInt(st.nextToken());
				arr[i][j] = k;
				// 바이러스 인경우
				if (k == 2) {
					virus[vIndex++] = new Virus(i, j);
				}

				if (k == 0) {
					zeroCnt++;
				}
			}
		}

		pick(0, 0);
		if (MIN == Integer.MAX_VALUE) {
			System.out.println(-1);
		} else {
			System.out.println(MIN);
		}

		bf.close();
	}

	static void pick(int index, int cnt) {

		// M개의 위치선택한 경우
		if (cnt == M) {
			// System.out.println("선택완료");
			int[][] picked = copy(arr);
			// 바이러스 퍼지기
			spread(picked);
			return;
		}

		// virus의 Index를 벗어난경우
		if (index == vIndex) {
			return;
		}

		Virus v = virus[index];
		selected[sIndex++] = v;
		// 해당위치 선택
		pick(index + 1, cnt + 1);

		// 해당위치 미선택
		selected[--sIndex] = null;
		pick(index + 1, cnt);
	}

	static void spread(int[][] arr) {

		// printSelected();
		// 모든 빈칸 바이러스 퍼졌는지 확인
		if (check(arr)) {
			MIN = 0;
			return;
		}

		// 이미 퍼진곳 체크
		int[][] check = new int[N][N];
		Queue<Virus> queue = new LinkedList<Virus>();
		for (int i = 0; i < M; i++) {
			Virus v = selected[i];
			queue.add(v);
			arr[v.x][v.y] = 3;
			check[v.x][v.y] = 1;
		}
		//System.out.println("퍼지기전");
		//print(arr);
		
		int cnt = 0;
		int zCnt = 0;
		while (!queue.isEmpty()) {
			Virus t = queue.poll();
			int x = t.x;
			int y = t.y;

			//System.out.println(zCnt  + " 없앰 , " + t.cnt);
			if (t.cnt > MIN) {
				break;
			}

			if (zCnt == zeroCnt) {
				break;
			}

			for (int i = 0; i < 4; i++) {
				if (safe(x + dx[i], y + dy[i]) && check[x + dx[i]][y + dy[i]] == 0
						&& (arr[x + dx[i]][y + dy[i]] == 0 || arr[x + dx[i]][y + dy[i]] == 2)) {
					Virus ve = new Virus(x + dx[i], y + dy[i]);
					ve.cnt = t.cnt + 1;
					// 최종시간 갱신
					cnt = ve.cnt;
					// 빈칸이였을 경우
					if (arr[x + dx[i]][y + dy[i]] == 0) {
						zCnt++;
					}
					arr[x + dx[i]][y + dy[i]] = 3;
					check[x + dx[i]][y + dy[i]] = 1;
					queue.add(ve);


				}
			}
		}
		//System.out.println("퍼진후");
		//print(arr);
		//System.out.println("카운트 : " + cnt);
		
		if(check(arr)) {
			if (cnt < MIN) {
				MIN = cnt;
			}
		}
	}

	static boolean check(int[][] arr) {

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (arr[i][j] == 0) {
					return false;
				}
			}
		}
		return true;
	}

	static void printSelected() {
		for (int i = 0; i < M; i++) {
			System.out.println(selected[i].x + "," + selected[i].y);
		}
	}

	static int[][] copy(int[][] arr) {

		int[][] temp = new int[N][N];

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				temp[i][j] = arr[i][j];
			}
		}

		return temp;
	}

	static class Virus {
		int x;
		int y;
		int cnt;

		Virus(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	static boolean safe(int x, int y) {
		return (x >= 0) && (y >= 0) && (x < N) && (y < N);
	}

	static void print(int[][] arr) {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println("---------------");
	}
}
