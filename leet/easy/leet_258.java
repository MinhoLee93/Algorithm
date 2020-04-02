package leetcode;

public class leet_258 {

    public static void main(String[] args) {
        int num = 10;
        System.out.println(addDigits(num));

    }

    static int addDigits(int num) {
        if (num < 10) {
            return num;
        }

        int temp = 0;
        while (num >= 10) {
            temp += num % 10;
            num = num / 10;
        }

        temp = temp + num;
        return addDigits(temp);
    }
}
