package leetcode;

import java.util.Arrays;
import java.util.Collection;

public class leet_1046 {

    public static void main(String[] args) {
        int[] arr = {2, 7, 4, 1, 8, 1};
        int max = arr.length - 1;
        int cnt = 0;
        while (arr.length - cnt > 1) {
            Arrays.sort(arr);
            print(arr);

            int x = arr[max - 1];
            int y = arr[max];
            System.out.println("x : " + x + " , y : " + y);

            if (x == y) {
                arr[max - 1] = 0;
                arr[max] = 0;
                cnt = cnt + 2;
            } else if (x < y) {
                arr[max] = arr[max] - arr[max - 1];
                arr[max - 1] = 0;
                cnt++;
            }
        }

        Arrays.sort(arr);
        System.out.println(arr[max]);
    }

    public static void print(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}
