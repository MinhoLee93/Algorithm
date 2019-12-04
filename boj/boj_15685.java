package samsung;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class N {
	static int[][] arr = new int[101][101];
	static int N;
	static int[] dx = { 0, -1, 0, 1 };
	static int[] dy = { 1, 0, -1, 0 };

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		N = Integer.parseInt(bf.readLine());

		for (int i = 0; i < N; i++) {
			String s = bf.readLine();
			st = new StringTokenizer(s);

			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			int g = Integer.parseInt(st.nextToken());

			List<Node> n = new ArrayList<Node>();
			// 시작점 add
			n.add(new Node(y, x));
			arr[y][x] = 1;

			switch (d) {
			// 오
			case 0:
				n.add(new Node(y, x + 1));
				arr[y][x + 1] = 1;
				// 드래곤, 현세대, 마지막 세대
				solve(n, 0, g);
				break;
			// 위
			case 1:
				n.add(new Node(y - 1, x));
				arr[y - 1][x] = 1;
				solve(n, 0, g);
				break;
			// 왼
			case 2:
				n.add(new Node(y, x - 1));
				arr[y][x - 1] = 1;
				solve(n, 0, g);
				break;
			// 아
			case 3:
				n.add(new Node(y + 1, x));
				arr[y + 1][x] = 1;
				solve(n, 0, g);
				break;
			}

		}

		// 드래곤 커브 꼭지점 check
		System.out.println(check());
	}

	public static int check() {
		int temp = 0;

		for (int i = 0; i < 100; i++) {
			for (int j = 0; j < 100; j++) {
				if (arr[i][j] == 1) {
					if (arr[i][j + 1] + arr[i + 1][j] + arr[i + 1][j + 1] == 3) {
						temp++;
					}
				}
			}
		}

		return temp;
	}

	public static void solve(List<Node> old, int cur, int end) {

		// 현시점 드래곤커브 출력
		//System.out.println("현세대 : " + cur);

		// 세대 end
		if (cur == end) {
			return;
		}

		// 신세대
		List<Node> ne = new ArrayList<Node>();
		// 기존 세대의 꼬리
		Node oTail = old.get(old.size() - 1);
		//System.out.println("기존 세대 꼬리 : " + oTail.x + " , " + oTail.y);
		// 신세대의 머리
		ne.add(oTail);

		for (int i = old.size() - 2; i >= 0; i--) {
			// 이전 Node
			Node oBefore = old.get(i);
			//System.out.println("기존 세대 이전 Node : " + oBefore.x + " , " + oBefore.y);
			
			// 어느방향인지 check
			for (int j = 0; j < 4; j++) {
				if (oTail.x + dx[j] == oBefore.x && oTail.y + dy[j] == oBefore.y) {
					// 신세대의 꼬리
					Node nTail = ne.get(ne.size() - 1);

					int x = nTail.x + dx[(j + 3) % 4];
					int y = nTail.y + dy[(j + 3) % 4];

					//System.out.println("추가)  x : " + x + " , " + "y : " + y);
					ne.add(new Node(x, y));
					arr[x][y] = 1;
					//printArr(arr);
				}
			}

			// 꼬리 Node 갱신
			oTail = oBefore;
		}
		
		ne.remove(0);
		// 세대 합치기
		old.addAll(ne);
		// 다음세대로 진입
		solve(old, cur + 1, end);

	}

	public static class Node {
		int x;
		int y;

		Node(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	public static void printArr(int[][] arr) {
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println("-----------------------");
	}
}
