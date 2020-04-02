class Solution {
    public int hammingDistance(int x, int y) {
        int c = x ^ y;
        int result = 0;

        for (int i = 30; i >= 0; i--) {
            int base = (int) Math.pow(2, i);
            result += c / Math.pow(2, i);
            c = c % base;
        }

        return result;
    }
}