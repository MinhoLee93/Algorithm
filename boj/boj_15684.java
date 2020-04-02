package samsung;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N2 {

    static int N;
    static int H;
    static int M;
    static int[][] arr;
    static int MIN = Integer.MAX_VALUE;
    static int nu = 1;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(bf.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());

        arr = new int[H + 1][N + 1];
        // print(arr);

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(bf.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            arr[x][y] = nu;
            arr[x][y + 1] = nu++;
        }

        make(arr, 0, 1, 1);
        if (MIN == Integer.MAX_VALUE) {
            System.out.println(-1);
        } else {
            System.out.println(MIN);
        }

        bf.close();
    }

    public static boolean safe(int y) {
        return (y >= 1) && (y <= N);
    }

    public static boolean check(int[][] arr) {
        // System.out.println("---------------");
        // print(arr);

        for (int j = 1; j <= N; j++) {
            int base = j;
            for (int i = 1; i <= H; i++) {
                // System.out.println("x: " + i + " y: " + base);
                if (arr[i][base] != 0) {
                    if (safe(base + 1) && (arr[i][base + 1] == arr[i][base])) {
                        base = base + 1;
                    } else if (safe(base - 1) && (arr[i][base - 1] == arr[i][base])) {
                        base = base - 1;
                    }
                } else {
                    continue;
                }
            }
            if (base != j) {
                return false;
            }
        }

        return true;
    }

    public static void make(int[][] arr, int cnt, int x, int y) {

        if (cnt > MIN) {
            return;
        }

        if (check(arr)) {
            // System.out.println("---------------");
            if (MIN > cnt) {
                MIN = cnt;
            }
        }

        if (cnt >= 3) {
            return;
        }

        for (int j = y; j <= (N - 1); j++) {
            for (int i = x; i <= H; i++) {
                if (arr[i][j] == 0 && arr[i][j + 1] == 0) {
                    arr[i][j] = nu;
                    arr[i][j + 1] = nu++;
                    make(arr, cnt + 1, x, y + 1);
                    arr[i][j] = 0;
                    arr[i][j + 1] = 0;
                    nu--;
                }
            }
            x = 1;
        }
    }

    public static void print(int[][] arr) {

        for (int i = 1; i <= H; i++) {
            for (int j = 1; j <= N; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }

    }
}
