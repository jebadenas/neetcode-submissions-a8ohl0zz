class Solution {
    public int maxProfit(int[] prices) {
        int res = 0;

        int l = 0;
        int r = 1;

        while (r < prices.length){
            r = l+1 ;

            while (r < prices.length && prices[r] > prices[l]){
                
                int cur = prices[r] - prices[l];
                System.out.println(String.format("%d - %d = %d",prices[r],prices[l], cur));
                res = Math.max(prices[r] - prices[l], res);
                r++;
            }

            l=r;

        }

        return res;
    }
}
