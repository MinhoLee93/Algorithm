package samsung;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N {
	static int N;
	static int K;

	static int[][] arr;
	static int[] dx = { 1, 0, -1, 0 };
	static int[] dy = { 0, 1, 0, -1 };

	static Node[] snake;
	static int head = 0;
	static int tail = 0;
	// 0: �Ʒ� , 1: ������, 2: ����, 3: ����
	static int move;

	// ȸ��
	static int L;
	static Time[] time;
	static int tIndex = 0;

	static int result = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(bf.readLine());
		arr = new int[N][N];
		K = Integer.parseInt(bf.readLine());

		snake = new Node[N * N];
		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(bf.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());

			// ��� ��ġ ���
			arr[x - 1][y - 1] = 7;
		}

		L = Integer.parseInt(bf.readLine());
		time = new Time[L];

		for (int i = 0; i < L; i++) {
			st = new StringTokenizer(bf.readLine());
			int x = Integer.parseInt(st.nextToken());
			String y = st.nextToken();

			// ȸ������ ��ȯ ���
			time[i] = new Time(x, y);
		}

		// ù ��ġ
		snake[0] = new Node(0, 0);
		arr[0][0] = 1;
		// ó�� ������ ������
		move = 1;
		solve(result);
		System.out.println(result+1);

		bf.close();
	}

	static void solve(int t) {
		//System.out.println("solve : " + t);

		// ȸ�������� �ٲ�� �� �ð��̸� (�ð� index Ȯ��)
		if (tIndex < time.length && time[tIndex].x == t) {
			move(time[tIndex].y);
			// time Index update
			tIndex++;
		}

		Node he = snake[head];
		// ���� �ƴϰ� && �ڱ��ڽ��� �ƴҰ��
		if (safe(he.x + dx[move], he.y + dy[move]) && arr[he.x + dx[move]][he.y + dy[move]] != 1) {

			// ����ϰ��
			if (arr[he.x + dx[move]][he.y + dy[move]] == 7) {

			} else {
				// ������� �����
				Node ta = snake[tail];
				arr[ta.x][ta.y] = 0;
				tail++;
			}

			// �Ӹ��� ����ĭ�� ��ġ
			arr[he.x + dx[move]][he.y + dy[move]] = 1;
			snake[++head] = new Node(he.x + dx[move], he.y + dy[move]);

			// �������� ����
			solve(++result);
		} else {
			return;
		}
	}

	// �Ӹ� ȸ��
	static void move(String s) {

		if (s.equals("L")) {
			switch (move) {
			case 0:
				move = 1;
				break;
			case 1:
				move = 2;
				break;
			case 2:
				move = 3;
				break;
			case 3:
				move = 0;
				break;
			}
		} else if (s.equals("D")) {
			switch (move) {
			case 0:
				move = 3;
				break;
			case 1:
				move = 0;
				break;
			case 2:
				move = 1;
				break;
			case 3:
				move = 2;
				break;
			}
		}
	}

	static boolean safe(int x, int y) {
		return (x >= 0) && (y >= 0) && (x < N) && (y < N);
	}

	static void print() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println("----------");
	}

	static class Time {
		int x;
		String y;

		Time(int x, String y) {
			this.x = x;
			this.y = y;
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
