class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int max = Integer.MIN_VALUE;

        for (int i: piles){
            max = Math.max(max, i);
        }

        int res = max;

        int l =0, r= max;

        while (l<=r){
            int curK = l + (r-l)/2;
            long sum = 0;

            for (int a: piles){
                sum += Math.ceil((double) a/curK);
            }

            if (sum <= h){
                r = curK - 1;
                res = curK;
            }else{
                l = curK + 1;
            }        }

        return res;
    }
}
