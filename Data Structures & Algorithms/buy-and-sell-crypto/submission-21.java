class Solution {
    public int maxProfit(int[] prices) {
        int res = 0;

        int l = 0;
        int r = 1;

        while (r < prices.length){
           if (prices[r] > prices[l]){
            int profit = prices[r] - prices[l];
            System.out.println(profit);
            res = Math.max(res, profit);

           }else{
            l=r;
           }
           r++;
        }

        return res;
    }
}
