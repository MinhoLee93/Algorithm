package samsung;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N1 {
	// 0, 1, 2, 3
	static int[] dx = { -1, 0, 1, 0 };
	static int[] dy = { 0, 1, 0, -1 };
	static int result;
	static int N = 0;
	static int M = 0;

	static int[][] arr;

	// 0: û�Ҿ��Ѱ�, 1 : �� , 2 : û���Ѱ�
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(bf.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N][M];

		st = new StringTokenizer(bf.readLine());
		int r = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		int d = Integer.parseInt(st.nextToken());

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(bf.readLine());
			for (int j = 0; j < M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		solve(r, c, d);
		System.out.println(result);
		bf.close();
	}

	static void solve(int r, int c, int d) {
		// System.out.println("r : " + r + " , c : " + c + " , d : " + d);
		// ������ġ û��
		if (arr[r][c] == 0) {
			arr[r][c] = 2;
			result++;
		}

		// printArr();

		for (int i = 3; i >= 0; i--) {

			// û������ ���� ������ �ִٸ�?
			if (safe(r + dx[(d + i) % 4], c + dy[(d + i) % 4]) && arr[r + dx[(d + i) % 4]][c + dy[(d + i) % 4]] == 0) {
				// �׹������� ȸ���ϰ�, ��ĭ����
				solve(r + dx[(d + i) % 4], c + dy[(d + i) % 4], (d + i) % 4);
				break;
			}

			// �׹��� ��� û�� or ���ΰ��
			if (i == 0) {
				if (safe(r + dx[(d + 2) % 4], c + dy[(d + 2) % 4])
						&& arr[r + dx[(d + 2) % 4]][c + dy[(d + 2) % 4]] == 2) {
					// System.out.println("����###################");
					solve(r + dx[(d + 2) % 4], c + dy[(d + 2) % 4], d);
					break;
				} else {
					break;
				}
			}
		}
	}

	static boolean safe(int x, int y) {
		return (x >= 0) && (y >= 0) && (x < N) && (y < M);
	}

	static void printArr() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println();
	}
}
