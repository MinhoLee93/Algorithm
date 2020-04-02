package samsung;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N1 {
    static int N;
    static int[][] arr;
    static int MAX = 0;

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(bf.readLine());
        arr = new int[N][2];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(bf.readLine());
            int t = Integer.parseInt(st.nextToken());
            int p = Integer.parseInt(st.nextToken());

            arr[i][0] = t;
            arr[i][1] = p;
        }

        solve(0, 0);
        System.out.println(MAX);
        bf.close();
    }

    static void solve(int x, int sum) {
        //System.out.println("x : " + x + " , sum : " + sum);
        if (x == N) {
            if (sum > MAX) {
                MAX = sum;
            }
            return;
        }

        // ���� index + ���ϴ³��Ǽ�
        if (x + arr[x][0] <= N) {
            solve(x + arr[x][0], sum + arr[x][1]);
            solve(x + 1, sum);
        } else {
            solve(x + 1, sum);
        }
    }

    // N������ ��ȿ, N+1�� �Ѿ�� out
}
