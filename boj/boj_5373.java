package samsung;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N {
	static int[][] cube_base = { { 0, 0, 0, 0, 0, 0, 0, 0, 0 },
			{ 1, 1, 1, 1, 1, 1, 1, 1, 1 }, { 2, 2, 2, 2, 2, 2, 2, 2, 2 },
			{ 3, 3, 3, 3, 3, 3, 3, 3, 3 }, { 4, 4, 4, 4, 4, 4, 4, 4, 4 },
			{ 5, 5, 5, 5, 5, 5, 5, 5, 5 } };

	static int[][] cube = new int[6][9];

	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int test = Integer.parseInt(bf.readLine());
		StringTokenizer st;

		for (int i = 0; i < test; i++) {
			// Reset Data of Cube
			resetCube();

			// 2
			int k = Integer.parseInt(bf.readLine());

			// F+ B+
			st = new StringTokenizer(bf.readLine());

			for (int j = 0; j < k; j++) {
				Do(st.nextToken());
			}

			append();
		}
		
		System.out.println(sb.toString());
		bf.close();
	}

	// ���������� ������ �Լ�
	static void doRight(char e) {

		switch (e) {
		case 'U':
			int n40 = cube[4][0];
			int n41 = cube[4][1];
			int n42 = cube[4][2];
			
			cube[4][0] = cube[2][0];
			cube[4][1] = cube[2][1];
			cube[4][2] = cube[2][2];
			
			cube[2][0] = cube[5][0];
			cube[2][1] = cube[5][1];
			cube[2][2] = cube[5][2];
			
			cube[5][0] = cube[3][0];
			cube[5][1] = cube[3][1];
			cube[5][2] = cube[3][2];
			        
			cube[3][0] = n40;
			cube[3][1] = n41;
			cube[3][2] = n42;
			        
			     
			selfRight(0);
			break;
		case 'D':
			int n46 = cube[4][6];
			int n47 = cube[4][7];
			int n48 = cube[4][8];

			
			cube[4][6] = cube[3][6];
			cube[4][7] = cube[3][7];
			cube[4][8] = cube[3][8];
			
			cube[3][6] = cube[5][6];
			cube[3][7] = cube[5][7];
			cube[3][8] = cube[5][8];
			
			cube[5][6] = cube[2][6];
			cube[5][7] = cube[2][7];
			cube[5][8] = cube[2][8];
			        
			cube[2][6] = n46;
			cube[2][7] = n47;
			cube[2][8] = n48;
			
			
			selfRight(1);
			break;
		case 'F':
			int n06 = cube[0][6];
			int n07 = cube[0][7];
			int n08 = cube[0][8];
			
			cube[0][6] = cube[4][8];
			cube[0][7] = cube[4][5];
			cube[0][8] = cube[4][2];
			
			cube[4][8] = cube[1][2];
			cube[4][5] = cube[1][1];
			cube[4][2] = cube[1][0];
			
			cube[1][2] = cube[5][0];
			cube[1][1] = cube[5][3];
			cube[1][0] = cube[5][6];
			        
			cube[5][0] = n06;
			cube[5][3] = n07;
			cube[5][6] = n08;
			
			selfRight(2);
			break;
		case 'B':
			int n02 = cube[0][2];
			int n01 = cube[0][1];
			int n00 = cube[0][0];
			
			cube[0][2] = cube[5][8];
			cube[0][1] = cube[5][5];
			cube[0][0] = cube[5][2];
			
			cube[5][8] = cube[1][6];
			cube[5][5] = cube[1][7];
			cube[5][2] = cube[1][8];
			
			cube[1][6] = cube[4][0];
			cube[1][7] = cube[4][3];
			cube[1][8] = cube[4][6];
			        
			cube[4][0] = n02;
			cube[4][3] = n01;
			cube[4][6] = n00;

			selfRight(3);
			break;
		case 'L':
			int n20 = cube[2][0];
			int n23 = cube[2][3];
			int n26 = cube[2][6];
			
			cube[2][0] = cube[0][0];
			cube[2][3] = cube[0][3];
			cube[2][6] = cube[0][6];
			
			cube[0][0] = cube[3][8];
			cube[0][3] = cube[3][5];
			cube[0][6] = cube[3][2];
			
			cube[3][8] = cube[1][0];
			cube[3][5] = cube[1][3];
			cube[3][2] = cube[1][6];
			        
			cube[1][0] = n20;
			cube[1][3] = n23;
			cube[1][6] = n26;
			
			selfRight(4);
			break;
		case 'R':
			int n22 = cube[2][2];
			int n25 = cube[2][5];
			int n28 = cube[2][8];
			
			cube[2][2] = cube[1][2];
			cube[2][5] = cube[1][5];
			cube[2][8] = cube[1][8];
			
			cube[1][2] = cube[3][6];
			cube[1][5] = cube[3][3];
			cube[1][8] = cube[3][0];
			
			cube[3][6] = cube[0][2];
			cube[3][3] = cube[0][5];
			cube[3][0] = cube[0][8];
			        
			cube[0][2] = n22;
			cube[0][5] = n25;
			cube[0][8] = n28;
			
			selfRight(5);
			break;
		}
	}

	// �������� ������ �Լ�
	static void doLeft(char e) {

		switch (e) {
		case 'U':
			int n40 = cube[4][0];
			int n41 = cube[4][1];
			int n42 = cube[4][2];
			
			cube[4][0] = cube[3][0];
			cube[4][1] = cube[3][1];
			cube[4][2] = cube[3][2];
			
			cube[3][0] = cube[5][0];
			cube[3][1] = cube[5][1];
			cube[3][2] = cube[5][2];
			
			cube[5][0] = cube[2][0];
			cube[5][1] = cube[2][1];
			cube[5][2] = cube[2][2];
			
			cube[2][0] = n40;
			cube[2][1] = n41;
			cube[2][2] = n42;
			
		
			selfLeft(0);
			break;
		case 'D':
			int n46 = cube[4][6];
			int n47 = cube[4][7];
			int n48 = cube[4][8];

			
			cube[4][6] = cube[2][6];
			cube[4][7] = cube[2][7];
			cube[4][8] = cube[2][8];
			
			cube[2][6] = cube[5][6];
			cube[2][7] = cube[5][7];
			cube[2][8] = cube[5][8];
			
			cube[5][6] = cube[3][6];
			cube[5][7] = cube[3][7];
			cube[5][8] = cube[3][8];
			        
			cube[3][6] = n46;
			cube[3][7] = n47;
			cube[3][8] = n48;
			
			selfLeft(1);
			break;
		case 'F':
			int n06 = cube[0][6];
			int n07 = cube[0][7];
			int n08 = cube[0][8];
			
			cube[0][6] = cube[5][0];
			cube[0][7] = cube[5][3];
			cube[0][8] = cube[5][6];
			
			cube[5][0] = cube[1][2];
			cube[5][3] = cube[1][1];
			cube[5][6] = cube[1][0];
			
			cube[1][2] = cube[4][8];
			cube[1][1] = cube[4][5];
			cube[1][0] = cube[4][2];
			        
			cube[4][8] = n06;
			cube[4][5] = n07;
			cube[4][2] = n08;
			
			selfLeft(2);
			break;
		case 'B':
			int n02 = cube[0][2];
			int n01 = cube[0][1];
			int n00 = cube[0][0];
			
			cube[0][2] = cube[4][0];
			cube[0][1] = cube[4][3];
			cube[0][0] = cube[4][6];
			
			cube[4][0] = cube[1][6];
			cube[4][3] = cube[1][7];
			cube[4][6] = cube[1][8];
			
			cube[1][6] = cube[5][8];
			cube[1][7] = cube[5][5];
			cube[1][8] = cube[5][2];
			        
			cube[5][8] = n02;
			cube[5][5] = n01;
			cube[5][2] = n00;
			
			selfLeft(3);
			break;
		case 'L':
			int n20 = cube[2][0];
			int n23 = cube[2][3];
			int n26 = cube[2][6];
			
			cube[2][0] = cube[1][0];
			cube[2][3] = cube[1][3];
			cube[2][6] = cube[1][6];
			
			cube[1][0] = cube[3][8];
			cube[1][3] = cube[3][5];
			cube[1][6] = cube[3][2];
			
			cube[3][8] = cube[0][0];
			cube[3][5] = cube[0][3];
			cube[3][2] = cube[0][6];
			        
			cube[0][0] = n20;
			cube[0][3] = n23;
			cube[0][6] = n26;
			
			selfLeft(4);
			break;
		case 'R':
			int n22 = cube[2][2];
			int n25 = cube[2][5];
			int n28 = cube[2][8];
			
			cube[2][2] = cube[0][2];
			cube[2][5] = cube[0][5];
			cube[2][8] = cube[0][8];
			
			cube[0][2] = cube[3][6];
			cube[0][5] = cube[3][3];
			cube[0][8] = cube[3][0];
			
			cube[3][6] = cube[1][2];
			cube[3][3] = cube[1][5];
			cube[3][0] = cube[1][8];
			        
			cube[1][2] = n22;
			cube[1][5] = n25;
			cube[1][8] = n28;
			
			selfLeft(5);
			break;
		}
	}

	// ���������� ������ ������ ���°�
	static void selfRight(int s) {
		// 1
		int n0 = cube[s][0];
		int n1 = cube[s][1];
		int n2 = cube[s][2];

		// 2
		int n3 = cube[s][3];
		int n4 = cube[s][4];
		int n5 = cube[s][5];

		// 3
		int n6 = cube[s][6];
		int n7 = cube[s][7];
		int n8 = cube[s][8];

		// 1
		cube[s][0] = n6;
		cube[s][1] = n3;
		cube[s][2] = n0;

		// 2
		cube[s][3] = n7;
		cube[s][4] = n4;
		cube[s][5] = n1;

		// 3
		cube[s][6] = n8;
		cube[s][7] = n5;
		cube[s][8] = n2;
	}

	// �������� ������ ������ ���°�
	static void selfLeft(int s) {

		// 1
		int n0 = cube[s][0];
		int n1 = cube[s][1];
		int n2 = cube[s][2];

		// 2
		int n3 = cube[s][3];
		int n4 = cube[s][4];
		int n5 = cube[s][5];

		// 3
		int n6 = cube[s][6];
		int n7 = cube[s][7];
		int n8 = cube[s][8];

		// 1
		cube[s][0] = n2;
		cube[s][1] = n5;
		cube[s][2] = n8;

		// 2
		cube[s][3] = n1;
		cube[s][4] = n4;
		cube[s][5] = n7;

		// 3
		cube[s][6] = n0;
		cube[s][7] = n3;
		cube[s][8] = n6;
	}

	static void Do(String s) {
		if (s.charAt(1) == '+') {
			// ���������� ������
			doRight(s.charAt(0));
		} else {
			// �������� ������
			doLeft(s.charAt(0));
		}

		return;
	}

	static void resetCube() {

		for (int i = 0; i < 6; i++) {
			for (int j = 0; j < 9; j++) {
				cube[i][j] = cube_base[i][j];
			}
		}
	}

	static void append() {

		for (int i = 0; i < 9; i++) {
			sb.append(check(cube[0][i]));
			if ((i + 1) % 3 == 0) {
				sb.append('\n');
			}
		}
	}

	static char check(int n) {
		switch (n) {
		case 0:
			return 'w';
		case 1:
			return 'y';
		case 2:
			return 'r';
		case 3:
			return 'o';
		case 4:
			return 'g';
		case 5:
			return 'b';
		}

		return 'x';
	}
}
