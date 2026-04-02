class Solution {


    
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

        for (int stone:stones){
            maxHeap.offer(stone);
        }

        while (maxHeap.size() > 1){
            int first = maxHeap.poll();
            int second = maxHeap.poll();

            int result = Math.abs(first-second);

            if (result > 0){
                maxHeap.offer(result);
            }
        }

        return (maxHeap.size() >= 1) ?  maxHeap.peek() :  0;
    }
}
