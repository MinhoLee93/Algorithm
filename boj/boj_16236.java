package samsung;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class N {

    public static int N;
    public static int[][] arr;
    public static Shark shark;
    public static ArrayList<Fish> fishs = new ArrayList<>();

    public static int[] dx = {1, 0, -1, 0};
    public static int[] dy = {0, 1, 0, -1};

    public static int Result;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(bf.readLine());
        arr = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(bf.readLine());
            for (int j = 0; j < N; j++) {
                int k = Integer.parseInt(st.nextToken());
                arr[i][j] = k;

                if (k == 0) {

                } else if (k == 9) {
                    // ���
                    shark = new Shark(i, j, 2, 0);
                } else {

                }
            }
        }
        solve(0);
        System.out.println(Result);
        bf.close();
    }

    public static void solve(int cnt) {

        //System.out.println("solve " + cnt);
        //System.out.println("��� ũ�� : " + shark.size);
        //print();

        // ���̻� ��� ���� ����Ⱑ ���� ���
        if (!checkFish()) {
            Result = cnt;
            return;
        }

        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(shark.x, shark.y, 0));
        // �湮���� Ȯ��
        int[][] check = new int[N][N];
        check[shark.x][shark.y] = 1;

        // �ּ����� ã��
        int minX = N;
        int minY = N;
        int time = Integer.MAX_VALUE;
        while (!queue.isEmpty()) {
            Node temp = queue.poll();

            if (temp.cnt + 1 > time) {
                continue;
            }

            for (int i = 0; i < 4; i++) {
                if (safe(temp.x + dx[i], temp.y + dy[i]) && check[temp.x + dx[i]][temp.y + dy[i]] == 0) {
                    // ��ĭ
                    if (arr[temp.x + dx[i]][temp.y + dy[i]] == 0) {
                        Node t1 = new Node(temp.x + dx[i], temp.y + dy[i], temp.cnt + 1);
                        queue.add(t1);
                        // �湮 ���
                        check[temp.x + dx[i]][temp.y + dy[i]] = 1;

                        //System.out.println(
                        //		"add node : " + (temp.x + dx[i]) + "," + (temp.y + dy[i]) + "," + (temp.cnt + 1));

                    } else if (shark.size > arr[temp.x + dx[i]][temp.y + dy[i]]) {

                        time = (temp.cnt + 1); // ���� ã�� �ð� ���
                        //System.out.println(
                        //		"����� Ȯ�� : " + (temp.x + dx[i]) + " , " + (temp.y + dy[i]) + " , " + (temp.cnt + 1));
                        // �湮 ���
                        check[temp.x + dx[i]][temp.y + dy[i]] = 1;

                        // ������
                        if ((temp.x + dx[i]) < minX) {
                            minX = temp.x + dx[i];
                            minY = temp.y + dy[i];

                        } else if ((temp.x + dx[i]) == minX) {
                            // �������� ���� ����Ⱑ ���� ���
                            if (temp.y + dy[i] < minY) {
                                minX = temp.x + dx[i];
                                minY = temp.y + dy[i];
                            }
                        }

                    } else if (shark.size <= arr[temp.x + dx[i]][temp.y + dy[i]]) {
                        // ������
                        if (shark.size == arr[temp.x + dx[i]][temp.y + dy[i]]) {
                            // ������ �� ����
                            Node t2 = new Node(temp.x + dx[i], temp.y + dy[i], temp.cnt + 1);
                            //	System.out.println(
                            //			"add node : " + (temp.x + dx[i]) + "," + (temp.y + dy[i]) + "," + (temp.cnt + 1));
                            queue.add(t2);
                            // �湮 ���
                            check[temp.x + dx[i]][temp.y + dy[i]] = 1;
                        } else {
                            // ������ �� �� ����

                        }
                    }
                }
            }

        }

        // ����⸦ �߰����� ���
        if (minX != N && minY != N) {
            arr[minX][minY] = 9;
            arr[shark.x][shark.y] = 0;

            shark.x = minX;
            shark.y = minY;
            shark.cnt = shark.cnt + 1;

            if (shark.cnt == shark.size) {
                shark.size = shark.size + 1;
                shark.cnt = 0;
            }
            // System.out.println("�̵��ð� : " + time);

            solve(cnt + time);
        } else {
            Result = cnt;
            return;
        }
    }

    public static class Node {
        int x;
        int y;
        int cnt;

        Node(int x, int y, int cnt) {
            this.x = x;
            this.y = y;
            this.cnt = cnt;
        }
    }

    public static boolean safe(int x, int y) {
        return (x >= 0) && (y >= 0) && (x < N) && (y < N);
    }

    public static void print() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("------------");
    }

    // ��Ƹ��� �� �ִ� ����� Ȯ��
    public static boolean checkFish() {

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                // ��ĭ�� �ƴϸ鼭 && �ϳ��� ���� ����� ���� ����Ⱑ ���� ���
                if (arr[i][j] != 0 && (shark.size > arr[i][j])) {
                    return true;
                }
            }
        }

        return false;
    }

    public static class Shark {
        int x;
        int y;
        int size;
        int cnt;

        Shark(int x, int y, int size, int cnt) {
            this.x = x;
            this.y = y;
            this.size = size;
            this.cnt = cnt;
        }
    }

    public static class Fish {
        int x;
        int y;
        int size;

        Fish(int x, int y, int size) {
            this.x = x;
            this.y = y;
            this.size = size;
        }
    }
}
