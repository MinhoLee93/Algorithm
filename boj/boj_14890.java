package samsung;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N1 {
    public static int result;
    public static int[][] arr;
    public static int[][] check;
    public static int N;
    public static int L;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(bf.readLine());
        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());

        arr = new int[N][N];


        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(bf.readLine());
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        check = new int[N][N];
        checkPath(arr);
        check = new int[N][N];
        checkPath(rotateArr(arr));
        System.out.println(result);
        bf.close();
    }

    public static void checkPath(int[][] arr) {

        // �̵���δ� �� -> ��
        for (int i = 0; i < N; i++) {
            // �� �ٺ��� true or false üũ
            boolean flag = true;
            for (int j = 1; j < N; j++) {
                // �� -> ū
                if (arr[i][j] > arr[i][j - 1]) {
                    // 1���̰� �ƴϸ� false
                    if (arr[i][j] - arr[i][j - 1] != 1) {
                        flag = false;
                        break;
                    } else {
                        // 1���� ���ٸ�? base�� ��� ���� ���ƾ���
                        int base = arr[i][j - 1];

                        for (int k = 1; k <= L; k++) {
                            if (safe(j - k) && arr[i][j - k] == base && check[i][j - k] == 0) {
                                check[i][j - k] = 1;
                            } else {
                                flag = false;
                                break;
                            }
                        }
                    }

                } else if (arr[i][j] < arr[i][j - 1]) {
                    // ū -> ��
                    // 1���̰� �ƴϸ� false
                    if (arr[i][j - 1] - arr[i][j] != 1) {
                        flag = false;
                        break;
                    } else {
                        // 1���� ���ٸ�? base�� ��� ���� ���ƾ���
                        int base = arr[i][j];

                        for (int k = 0; k < L; k++) {
                            if (safe(j + k) && arr[i][j + k] == base && check[i][j + k] == 0) {
                                check[i][j + k] = 1;
                            } else {
                                flag = false;
                                break;
                            }
                        }
                    }
                } else {

                }

                // �̹� ���� ���°� ���������� �����ٷ� �̵�
                if (!flag) {
                    j = N;
                }
            }
            if (flag) {
                result++;
            }
        }
    }

    public static boolean safe(int x) {
        return (x >= 0) && (x < N);
    }

    public static int[][] rotateArr(int[][] arr) {
        int[][] temp = new int[N][N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                temp[i][j] = arr[j][(N - 1) - i];
            }
        }

        return temp;
    }

    public static void printArr(int[][] arr) {

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }
}
