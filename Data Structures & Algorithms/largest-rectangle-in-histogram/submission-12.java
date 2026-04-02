class Solution {
    public int largestRectangleArea(int[] heights) {
        int res = 0;

        Stack<int[]> stack = new Stack<int[]>();

        for (int i = 0; i < heights.length ; i++){
            int index = i;
            while (stack.size() > 0 && stack.peek()[1] > heights[i]){
                int[] current = stack.pop();
                int currentArea = current[1]*(i-current[0]);
                res = Math.max(res, currentArea);
                index = current[0];
            }
            System.out.println(index);
            stack.push(new int[]{index, heights[i]});
        }
        
        while (!stack.isEmpty()){
            int[] current = stack.pop();
            res = Math.max(res, current[1]*(heights.length - current[0]));
        }

        return res;
    }
}
