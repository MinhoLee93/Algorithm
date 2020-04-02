package leetcode;

public class leet_463 {
    static int[][] arr = {{1}};
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int[][] check;
    static int result;

    public static void main(String[] args) {
        check = new int[arr.length][arr[0].length];

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                if (arr[i][j] == 1) {
                    solve(i, j);
                    System.out.println(result);
                    return;
                }
            }
        }
    }

    public static void solve(int x, int y) {
        System.out.println("X : " + x + " , Y : " + y);
        check[x][y] = 1;
        for (int i = 0; i < 4; i++) {
            // ����ų�
            if (!safe(x + dx[i], y + dy[i])) {
                result++;
            } else if (safe(x + dx[i], y + dy[i]) && arr[x + dx[i]][y + dy[i]] == 0) {
                // �����
                result++;
            } else if (safe(x + dx[i], y + dy[i]) && arr[x + dx[i]][y + dy[i]] == 1
                    && check[x + dx[i]][y + dy[i]] == 0) {
                solve(x + dx[i], y + dy[i]);
            }
        }
    }

    public static void print(int[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("--------------");
    }

    public static boolean safe(int x, int y) {
        return (x >= 0) && (y >= 0) && (x < arr.length) && (y < arr[0].length);
    }
}
