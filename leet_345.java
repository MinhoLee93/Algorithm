package leetcode;

public class leet_345 {
    // a e i o u
    public static void main(String[] args) {
        String s = "";
        // String s = "hello";

        String[] arr = s.split("");
        int[] check = new int[arr.length];
        int start = 0;
        int end = arr.length - 1;

        while (start <= end) {

            // �����̸� while ��� ����.
            while (!check(arr[start]) && start < end) {
                start++;
            }

            while (!check(arr[end]) && start < end) {
                end--;
            }

            System.out.println("start : " + start + ", end : " + end);

            // swap
            if (check[start] + check[end] == 0) {
                String temp = arr[end];
                arr[end] = arr[start];
                arr[start] = temp;
            } else {
                break;
            }

            // check
            check[end] = 1;
            check[start] = 1;

            // move
            start++;
            end--;
        }

        String result = "";
        for (String w : arr) {
            result += w;
        }
    }

    public static boolean check(String s) {
        if (s.equals("a") || s.equals("e") || s.equals("i") || s.equals("o") || s.equals("u")) {
            return true;
        } else if (s.equals("A") || s.equals("E") || s.equals("I") || s.equals("O") || s.equals("U")) {
            return true;
        } else {
            return false;
        }
    }
}
