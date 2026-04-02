class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int[][] pairs = new int[position.length][2];

        for (int i = 0; i < pairs.length; i++){
            pairs[i][0] = position[i];
            pairs[i][1] = speed[i];
        }

        Arrays.sort(pairs, (a,b) -> Integer.compare(b[0], a[0]));

        // for (int[] i:pairs){
        //     System.out.println(Arrays.toString(i));
        // }

        Stack<Float> stack = new Stack<>();

        for (int i=0; i<pairs.length; i++){
            // System.out.println(String.format("%d, %d",pairs[i][0],pairs[i][1]));
            float time = (float)(target - pairs[i][0])/pairs[i][1];
            
            stack.push(time);
            if (stack.size()>1){
                if (stack.get(stack.size()-1) <= stack.get(stack.size()-2)){
                    stack.pop();
                }
            }
            
        }

        

        return stack.size();
    }
}
