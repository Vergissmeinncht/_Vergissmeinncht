public class MaxProfit {
    public int maxProfit(int[] prices) {
        int profit = 0;
        int buyprice = prices[0];
        int stock = 1;
        int i = 0;
        for(;i<prices.length - 1;i++) {
            if(prices[i] > prices[i+1] && stock == 1) {
                profit = profit + prices[i] - buyprice;
                stock = 0;
            }
            if(prices[i] <= prices[i+1] && stock==0) {
                stock = 1;
                buyprice = prices[i];
            }
        }
        if(stock==1) {
            profit = profit + prices[i] - buyprice;
        }
        return profit;
    }
}
