package samsung;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N {
    // ����
    static int N;
    // ����
    static int M;
    // ��� ����
    static int K;
    static int[] dice = new int[6];
    static int[] order;
    static int[][] arr;

    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(bf.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        arr = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(bf.readLine());
            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        order = new int[K];
        st = new StringTokenizer(bf.readLine());
        for (int i = 0; i < K; i++) {
            order[i] = Integer.parseInt(st.nextToken());
        }

        solve(x, y, 0, -1);
        bf.close();
    }

    static void solve(int x, int y, int index, int flag) {
        // System.out.println("x :" + x + " , y : " + y + " , index : " + index);

        // ����
        if (index >= K) {
            return;
        }

        // �̵��� ĭ�� �����ִ� ���� 0 �̸�
        if (flag == 1) {
            if (arr[x][y] == 0) {
                arr[x][y] = dice[5];
            } else {
                dice[5] = arr[x][y];
                arr[x][y] = 0;
            }
        }

        // �̵�
        switch (order[index]) {
            case 1:
                if (safe(x, y + 1)) {
                    dice = right(dice);
                    System.out.println(dice[0]);
                    solve(x, y + 1, index + 1, 1);
                } else {
                    solve(x, y, index + 1, -1);
                }
                break;
            case 2:
                if (safe(x, y - 1)) {
                    dice = left(dice);
                    System.out.println(dice[0]);
                    solve(x, y - 1, index + 1, 1);
                } else {
                    solve(x, y, index + 1, -1);
                }
                break;
            case 3:
                if (safe(x - 1, y)) {
                    dice = up(dice);
                    System.out.println(dice[0]);
                    solve(x - 1, y, index + 1, 1);
                } else {
                    solve(x, y, index + 1, -1);
                }
                break;
            case 4:
                if (safe(x + 1, y)) {
                    dice = down(dice);
                    System.out.println(dice[0]);
                    solve(x + 1, y, index + 1, 1);
                } else {
                    solve(x, y, index + 1, -1);
                }
                break;
        }
    }

    static boolean safe(int x, int y) {
        return (x >= 0) && (y >= 0) && (x < N) && (y < M);
    }

    static int[] right(int[] arr) {
        int[] temp = new int[6];

        temp[0] = arr[3];
        temp[1] = arr[1];
        temp[2] = arr[0];
        temp[3] = arr[5];
        temp[4] = arr[4];
        temp[5] = arr[2];

        return temp;
    }

    static int[] left(int[] arr) {
        int[] temp = new int[6];

        temp[0] = arr[2];
        temp[1] = arr[1];
        temp[2] = arr[5];
        temp[3] = arr[0];
        temp[4] = arr[4];
        temp[5] = arr[3];

        return temp;
    }

    static int[] up(int[] arr) {
        int[] temp = new int[6];

        temp[0] = arr[4];
        temp[1] = arr[0];
        temp[2] = arr[2];
        temp[3] = arr[3];
        temp[4] = arr[5];
        temp[5] = arr[1];

        return temp;
    }

    static int[] down(int[] arr) {
        int[] temp = new int[6];

        temp[0] = arr[1];
        temp[1] = arr[5];
        temp[2] = arr[2];
        temp[3] = arr[3];
        temp[4] = arr[0];
        temp[5] = arr[4];

        return temp;
    }
}
