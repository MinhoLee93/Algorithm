class Solution {
    public int countPrimes(int n) {

        if (n == 0 || n == 1 || n == 2) {
            return 0;
        }

        int[] check = new int[n];
        int result = n - 2;

        for (int i = 2; i < check.length; i++) {

            // 1 : already chekced
            for (int j = 2; i * j < check.length; j++) {
                if (check[i * j] == 1) {

                } else {
                    check[i * j] = 1;
                    result--;
                }
            }
        }

        return result;
    }
}