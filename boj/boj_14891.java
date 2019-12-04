package samsung;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N1 {
	static char[][] arr = new char[4][8];
	static int[] head = new int[4];
	static int[] rotate;

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		for (int i = 0; i < 4; i++) {
			arr[i] = bf.readLine().toCharArray();
		}

		int K = Integer.parseInt(bf.readLine());
		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(bf.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			solve(x - 1, y);

			for (int j = 0; j < 4; j++) {
				if (rotate[j] == 1) {
					head[j] = (head[j] + 7) % 8;
				} else if (rotate[j] == -1) {
					head[j] = (head[j] + 1) % 8;
				}
			}
		}

		//printArr();
		int result = 0;
		for (int i = 0; i < 4; i++) {
			if (arr[i][head[i]] == '1') {
				result += Math.pow(2, i);
			}
		}

		System.out.println(result);
	}

	static void printArr() {
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 8; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
	}

	// 톱니바퀴, 회전방향
	static void solve(int x, int y) {
		rotate = new int[4];
		
		// 자신
		rotate[x] = y;
		
		// 왼
		for (int i = x - 1; i >= 0; i--) {
			// 오른쪽 확인 값
			char left = arr[i + 1][(head[i + 1] + 6) % 8];
			if (arr[i][(head[i] + 2) % 8] != left) {
				// 본인 회전
				if (rotate[i + 1] == 1) {
					//System.out.println("왼 x : " + i + " , y : " + -1);
					rotate[i] = -1;
				} else {
					//System.out.println("왼 x : " + i + " , y : " + 1);
					rotate[i] = 1;
				}

			} else {
				break;
			}
		}

		//System.out.println("x : " + x + " , y : " + y);

		// 오
		for (int i = x + 1; i < 4; i++) {
			// 오른쪽 확인 값
			char right = arr[i - 1][(head[i - 1] + 2) % 8];
			if (arr[i][(head[i] + 6) % 8] != right) {
				// 본인 회전
				if (rotate[i - 1] == 1) {
					//System.out.println("오 x : " + i + " , y : " + -1);
					rotate[i] = -1;
				} else {
					//System.out.println("오 x : " + i + " , y : " + 1);
					rotate[i] = 1;
				}

			} else {
				break;
			}
		}
	}
}
