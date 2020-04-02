class Solution {
    public boolean isPowerOfTwo(int n) {
        if (n == 0) {
            return false;
        }

        int i = 0;
        while (true) {
            long temp = (long) Math.pow(2, i++);
            if (temp == n) {
                return true;
            }

            if (temp > n) {
                return false;
            }
        }
    }
}