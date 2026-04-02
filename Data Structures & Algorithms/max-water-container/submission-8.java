class Solution {
    public int maxArea(int[] heights) {
        
        int l = 0;
        int r = heights.length - 1;

        int currentMax = 0;

        while (l<r){
            System.out.println(String.format("%d, %d", l, r));
            int area = Math.min(heights[l], heights[r]) * (r-l);
            currentMax = Math.max(currentMax, area);

            if (heights[l]<=heights[r]){
                l++;;
            }else{
                r--;
            }
        }
        return currentMax;
    }
}
