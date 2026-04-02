class Solution {
    public int maxProfit(int[] prices) {
        int res = 0;

        // int runningProfit = 0;

        int i = 0;

        while (i + 1 < prices.length){
            if (prices[i] < prices[i+1]){
                res += prices[i+1] - prices[i];
            }

            i++;
        }

        return res;
        
    }
}