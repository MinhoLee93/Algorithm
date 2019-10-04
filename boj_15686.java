package samsung;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class SS {

	static ArrayList<Chicken> c = new ArrayList<>();
	static ArrayList<House> h = new ArrayList<>();
	static int[][] arr;

	static int N;
	static int M;

	static int MIN = Integer.MAX_VALUE;
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(bf.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N][N];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(bf.readLine());
			for (int j = 0; j < N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				// 집
				if (arr[i][j] == 1) {
					House house = new House(i, j);
					h.add(house);
				} else if (arr[i][j] == 2) {
					// 치킨집
					Chicken chicken = new Chicken(i, j, 1);
					c.add(chicken);
				}
			}
		}

		// index, 폐업시키지 않은 치킨집
		solve(0, c.size());
		System.out.println(MIN);
		bf.close();
	}

	static void solve(int index, int cnt) {

		// 남아있는 치킨집이 M보다 작을때
		if (cnt <= M) {
			// 도시 치킨거리
			int city = 0;
			for (int i = 0; i < h.size(); i++) {
				House house = h.get(i);
				int min = Integer.MAX_VALUE;
				for (int j = 0; j < c.size(); j++) {
					Chicken chicken = c.get(j);
					// 폐업하지 않은 치킨집일때
					if (chicken.flag == 1) {
						int temp = count(house, chicken);
						// 집의 치킨거리
						if (temp < min) {
							min = temp;
						}
					} else {
						continue;
					}
				}
				city += min;
			}

			if (city < MIN) {
				MIN = city;
			}

			// 치킨집은 적어도 1개
			if (cnt <= 1) {
				return;
			}
		}

		if (index == c.size()) {
			return;
		}

		// 폐업 x
		solve(index + 1, cnt);

		// 폐업 o
		Chicken chicken = c.get(index);
		chicken.flag = 0;
		c.set(index, chicken);

		solve(index + 1, cnt - 1);

		// 복구
		chicken = c.get(index);
		chicken.flag = 1;
		c.set(index, chicken);

	}

	static int count(House h, Chicken c) {

		return Math.abs(h.x - c.x) + Math.abs(h.y - c.y);

	}

	static class Chicken {
		int x;
		int y;
		int flag;

		Chicken(int x, int y, int flag) {
			this.x = x;
			this.y = y;
			this.flag = flag;
		}
	}

	static class House {
		int x;
		int y;

		House(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
}
