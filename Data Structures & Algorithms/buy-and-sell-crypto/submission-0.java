class Solution {
    public int maxProfit(int[] prices) {

        int profit = 0;
        
        if (prices.length == 1) {
            return profit;
        }

        int buy = 0;
        int sell = 1;

        while (sell < prices.length) {
            int diff = prices[sell] - prices[buy];
            if (diff <= 0) {
                buy = sell;
                sell += 1;
                continue;
            }

            profit = Math.max(profit, diff);
            sell += 1;
        }

        return profit;
    }
}
