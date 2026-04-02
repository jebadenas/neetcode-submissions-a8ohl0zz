//leftmost of deque is max of current window
//right is the most recent element added

class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
       int n = nums.length;
       int[] output = new int[n - k + 1];
       Deque<Integer> q = new LinkedList<>();

        int l = 0, r = 0;

        while (r < n){

            //we remove numbers that dont need to be there anymore
            while (!q.isEmpty() && nums[q.getLast()] < nums[r]){
                q.removeLast();
            }
            q.addLast(r);

            if (l > q.getFirst()){
                q.removeFirst();
            }


            //when the window is big enough we add to our return array
            if ((r + 1) >= k){
                output[l] = nums[q.getFirst()];
                l++;
            }
            r++;
        }

        return output;
}
}
