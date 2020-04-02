class Solution {

    public int maxProfit(int[] prices) {
        int result = 0;

        if (prices == null || prices.length == 0) {
            return 0;
        }

        int min = prices[0];
        for (int i = 1; i < prices.length; i++) {
            if (prices[i - 1] > prices[i] && prices[i - 1] > min) {
                result += (prices[i - 1] - min);
                min = prices[i];
            }

            if (prices[i] < min) {
                min = prices[i];
            }
        }

        if (prices[prices.length - 1] > min) {
            result += (prices[prices.length - 1] - min);
        }

        return result;
    }
}