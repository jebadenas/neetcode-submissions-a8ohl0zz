class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int res = Integer.MAX_VALUE;

        int l = 0;
        int r = 0;

        int runningSum = 0;

        while (r < nums.length){
            runningSum += nums[r];
            
            while (runningSum >= target){
                res = Math.min(res, r - l + 1);
                System.out.println(r);
                runningSum -= nums[l];
                l++;
            }


            
            r++;
        }

        return res == Integer.MAX_VALUE ? 0 : res;
    }
}