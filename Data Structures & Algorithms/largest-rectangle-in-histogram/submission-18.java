class Solution {
    public int largestRectangleArea(int[] heights) {
        int res = 0;

        // have a stack that tracks index, heights pairs
        Stack<int[]> stack = new Stack<>();

        for (int i = 0; i < heights.length; i++){
            //keep track of index changes for the push at the end
            int index = i;
            while (!stack.isEmpty() && stack.peek()[1] > heights[i]){
                int[] current = stack.pop();
                int area = (i-current[0])*current[1];
                res = Math.max(res, area);
                //change this index because current height can go all the way back to this index now for future calculations
                index = current[0];
            }

            stack.push(new int[]{index, heights[i]});
        }

        while(!stack.isEmpty()){
            int[] cur = stack.pop();
            int curArea = (heights.length - cur[0]) * cur[1];
            res = Math.max(res, curArea);
        }

        return res;
    }
}
