package samsung;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class N1 {

    static int r;
    static int c;
    static int k;

    // ��
    static int xIndex = 3;
    // ��
    static int yIndex = 3;

    static int[][] arr = new int[100][100];
    static int Result;

    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(bf.readLine());
        r = (Integer.parseInt(st.nextToken()) - 1);
        c = (Integer.parseInt(st.nextToken()) - 1);
        k = Integer.parseInt(st.nextToken());

        for (int i = 0; i < 3; i++) {
            st = new StringTokenizer(bf.readLine());
            for (int j = 0; j < 3; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        // print(arr);
        solve(0, arr);
        System.out.println(Result);
        bf.close();
    }

    static void solve(int cnt, int[][] arr) {

        if (arr[r][c] == k) {
            Result = cnt;
            return;
        }

        if (cnt > 100) {
            Result = -1;
            return;
        }

        // ���� ���� >= ���� ����
        if (xIndex >= yIndex) {
            // ������ ����
            //System.out.println("R����");
            int[][] r = RSolve(arr);
            solve(cnt + 1, r);
        } else {
            // ���� ���� < ���ǰ���
            //System.out.println("C����");
            int[][] c = CSolve(arr);
            // �Ʒ�����
            solve(cnt + 1, c);
        }

    }

    static int[][] copy(int[][] arr) {
        int[][] temp = new int[100][100];

        for (int i = 0; i < 100; i++) {
            for (int j = 0; j < 100; j++) {
                temp[i][j] = arr[i][j];
            }
        }

        return temp;
    }

    // 1: r / 2: c
    static int[][] RSolve(int[][] arr) {
        //print(arr);

        int[][] temp = new int[100][100];
        int max = 0;
        for (int i = 0; i < xIndex; i++) {
            //System.out.println("row : " + i);
            // ���ο� arr index
            int index = 0;

            Map<Integer, Integer> map = new HashMap<>();
            // ī��Ʈ �ϰ�
            for (int j = 0; j < yIndex; j++) {
                // ����
                int t = arr[i][j];
                // �̹� �ִٸ�?
                if (t != 0) {
                    if (map.containsKey(t)) {
                        map.replace(t, map.get(t) + 1);
                    } else {
                        map.put(t, 1);
                    }
                }
            }

            ArrayList<Node> n = new ArrayList<Node>();
            for (int s : map.keySet()) {
                int key = s;
                int value = map.get(s);

                Node ne = new Node(key, value);
                n.add(ne);
            }

            Collections.sort(n);
            for (Node sorted : n) {
                // 100�� �Ѿ�� ������
                if (index >= 100) {
                    break;
                }
                temp[i][index++] = sorted.x;
                temp[i][index++] = sorted.y;

                //System.out.println("Index : " + index);
                // �ִ� max üũ
                if (index > max) {
                    max = index;
                }
            }
        }

        yIndex = max;

        return temp;
    }

    static int[][] CSolve(int[][] arr) {
        //print(arr);

        int[][] temp = new int[100][100];
        int max = 0;
        for (int i = 0; i < yIndex; i++) {
            //System.out.println("row : " + i);
            // ���ο� arr index
            int index = 0;

            Map<Integer, Integer> map = new HashMap<>();
            // ī��Ʈ �ϰ�
            for (int j = 0; j < xIndex; j++) {
                // ����
                int t = arr[j][i];
                // �̹� �ִٸ�?
                if (t != 0) {
                    if (map.containsKey(t)) {
                        map.replace(t, map.get(t) + 1);
                    } else {
                        map.put(t, 1);
                    }
                }
            }

            ArrayList<Node> n = new ArrayList<Node>();
            for (int s : map.keySet()) {
                int key = s;
                int value = map.get(s);

                Node ne = new Node(key, value);
                n.add(ne);
            }

            Collections.sort(n);
            for (Node sorted : n) {
                // 100�� �Ѿ�� ������
                if (index >= 100) {
                    break;
                }
                temp[index++][i] = sorted.x;
                temp[index++][i] = sorted.y;

                //System.out.println("Index : " + index);
                // �ִ� max üũ
                if (index > max) {
                    max = index;
                }
            }
        }

        xIndex = max;

        return temp;
    }

    static boolean safe(int x, int y) {
        return (x >= 0) && (y >= 0) && (x < 100) && (y < 100);
    }

    static class Node implements Comparable<Node> {
        // ����
        public int x;
        // ī��Ʈ
        public int y;

        Node(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public int compareTo(Node o) {
            if (this.y > o.y) {
                return 1;
            } else if (this.y == o.y) {
                if (this.x > o.x) {
                    return 1;
                } else {
                    return -1;
                }
            } else {
                return -1;
            }

        }
    }

    static int[][] left(int[][] arr) {

        int[][] temp = new int[100][100];

        for (int i = 0; i < arr[0].length; i++) {
            for (int j = 0; j < arr.length; j++) {
                temp[i][j] = arr[j][(arr[0].length - 1) - i];
            }
        }

        return temp;
    }

    static int[][] right(int[][] arr) {

        int[][] temp = new int[100][100];

        for (int i = 0; i < arr[0].length; i++) {
            for (int j = 0; j < arr.length; j++) {
                temp[i][j] = arr[(arr.length - 1) - j][i];
            }
        }

        return temp;
    }

    static void print(int[][] arr) {

        for (int i = 0; i < xIndex; i++) {
            for (int j = 0; j < yIndex; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("--------------");
    }
}
