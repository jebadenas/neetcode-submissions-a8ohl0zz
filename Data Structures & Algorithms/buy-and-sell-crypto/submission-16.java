class Solution {
    public int maxProfit(int[] prices) {
        int res = 0;

        int l = 0;
        int r = 1;

        while (r < prices.length){
            if (prices[l] < prices[r]){
                int profit = prices[r] - prices[l];
                res = Math.max(profit, res);
                
            }else{
                l = r;
            }
            r++;
        }

        return res;
    }
}
