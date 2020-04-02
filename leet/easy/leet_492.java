class Solution {
    public int[] constructRectangle(int area) {
        int W = 1;
        int L = area;
        int min = Integer.MAX_VALUE;
        int[] result = new int[2];

        while (W <= L) {
            if (W * L <= area) {
                if (W * L == area) {
                    if (L - W < min) {
                        min = L - W;
                        result[0] = L;
                        result[1] = W;
                    }
                }
                W++;
            } else {
                L--;
            }
        }

        return result;
    }
}