class Solution {
    public int maxProfit(int[] prices) {
        int result = 0;
        boolean flag = false;
        int buyPrice = 0;
        for (int i = 0; i < prices.length - 1; i++) {
            // buy
            if (prices[i + 1] > prices[i]) {
                if (!flag) {
                    flag = true;
                    buyPrice = prices[i];
                    //System.out.println("buy : " + buyPrice);
                }
            } else {
                // sell
                if (flag) {
                    result += prices[i] - buyPrice;
                    flag = false;
                    //System.out.println("sell : " + prices[i]);
                }
            }
        }
        if (flag) {
            result += prices[prices.length - 1] - buyPrice;
        }

        return result;
    }
}