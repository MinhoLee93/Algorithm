class Solution {
    public int maxProfit(int[] prices) {
        int result = 0;

        for (int i = 0; i < prices.length - 1; i++) {
            int temp = prices[i];
            for (int j = i + 1; j < prices.length; j++) {
                if (prices[j] - temp > result) {
                    result = prices[j] - temp;
                }
            }
        }

        return result;
    }
}