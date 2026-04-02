class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        
        int[] res = new int[temperatures.length];
        Stack<int[]> stack = new Stack<>();

        for (int i=0; i<temperatures.length;i++){

            stack.push(new int[]{temperatures[i], i});
            
            if(stack.size() >= 2){
                int[] current = stack.pop();
                while (!stack.isEmpty() && current[0] > stack.peek()[0]){
                    int[] prev = stack.pop();
                    res[prev[1]] = current[1] - prev[1];
                }
                stack.push(current);

            }
            
        }
        
        return res;
    }
}
