class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int[] res = new int[temperatures.length];

        Stack<int[]> tempStack = new Stack<>();

        for (int i = 0; i < temperatures.length; i++){
            
            while (!tempStack.isEmpty() && tempStack.peek()[0] < temperatures[i]){
                int[] popTemp = tempStack.pop();

                int index = popTemp[1];
                res[index] = i - index;
            }

            tempStack.push(new int[]{temperatures[i],i});
        }

        return res;
    }
}
