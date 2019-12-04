package samsung;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N2 {

	static int R;
	static int C;
	static int M;

	static Shark[][] arr;
	static int Result;

	static int[] dx = { 0, -1, 1, 0, 0 };
	static int[] dy = { 0, 0, 0, 1, -1 };

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(bf.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		arr = new Shark[R][C];
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(bf.readLine());

			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			int s = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			int z = Integer.parseInt(st.nextToken());

			Shark shark = new Shark(r - 1, c - 1, s, d, z);

			arr[r - 1][c - 1] = shark;
		}

		solve();
		System.out.println(Result);

		bf.close();
	}

	public static void solve() {

		for (int j = 0; j < C; j++) {

			for (int i = 0; i < R; i++) {
				// 땅에서가장 가까운 상어 잡기
				if (arr[i][j] != null) {
					//System.out.println(i + "," + j);
					Result += arr[i][j].z;
					arr[i][j] = null;
					break;
				}
			}

			arr = move();
		}
	}

	public static boolean safe(int x, int y) {
		return (x >= 0) && (y >= 0) && (x < R) && (y < C);
	}

	public static Shark[][] move() {

		// 이동후 상어
		Shark[][] temp = new Shark[R][C];

		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				// 상어가 있다면
				if (arr[i][j] != null) {

					// 현재 상어 x,y 좌표
					int r = arr[i][j].r;
					int c = arr[i][j].c;
					int s = arr[i][j].s;
					int d = arr[i][j].d;
					int z = arr[i][j].z;

					//System.out.println(" 이동전 : " + r + "," + c + ", 방향: " + d);
					for (int k = 0; k < s; k++) {
						if (safe(r + dx[d], c + dy[d])) {
							r = r + dx[d];
							c = c + dy[d];
							//System.out.println("방향 : " + d);
						} else {
							switch (d) {
							case 1:
								d = 2;
								k = k -1;
								break;
							case 2:
								d = 1;
								k = k -1;
								break;
							case 3:
								d = 4;
								k = k -1;
								break;
							case 4:
								d = 3;
								k = k -1;
								break;
							}
						}
					}

					//System.out.println(" 이동후: " + r + "," + c + ", 방향: " + d);

					
					// 현재 비어있다면
					if (temp[r][c] == null) {
						temp[r][c] = new Shark(r, c, s, d, z);
					} else {
						// 새로운 상어가 더 클경우에만 해당 자리 차지
						if (temp[r][c].z < z) {
							temp[r][c] = new Shark(r, c, s, d, z);
						}
					}
				}
			}
		}

		return temp;
	}

	public static void print() {
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				System.out.print(arr[i][j].z + " ");
			}
			System.out.println();
		}
		System.out.println("------------------");
	}

	public static class Shark {
		int r;
		int c;
		int s;
		int d;
		int z;

		Shark(int r, int c, int s, int d, int z) {
			this.r = r;
			this.c = c;
			this.s = s;
			this.d = d;
			this.z = z;
		}
	}
}
