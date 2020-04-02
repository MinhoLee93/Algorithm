class Solution {
    public int[] plusOne(int[] digits) {
        int len = digits.length;
        boolean flag = false;
        digits[len - 1] = digits[len - 1] + 1;

        for (int i = len - 1; i >= 0; i--) {
            if (digits[i] >= 10) {
                digits[i] = digits[i] - 10;
                if (i == 0) {
                    flag = true;
                } else {
                    digits[i - 1] += 1;
                }
            } else {
                break;
            }
        }

        if (flag) {
            int[] result = new int[len + 1];
            result[0] = 1;
            for (int i = 1; i < len + 1; i++) {
                result[i] = digits[i - 1];
            }
            return result;
        } else {
            return digits;
        }
    }
}