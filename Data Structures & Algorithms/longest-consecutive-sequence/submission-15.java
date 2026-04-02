class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> numSet = new HashSet<>();
        
        for (int num: nums){
            numSet.add(num);
        }

        int longest = 0;

        for (int num: nums){
            int length = 1;
            int cur = num;
            System.out.println("current" + (cur));
            if (!numSet.contains((cur-1))){

                while (numSet.contains(cur+1)){
                    cur++;
                    length++;
            }
            }
            System.out.println("current" + cur);
            System.out.println(length + "," + num);
            longest = Math.max(longest, length);

        }

        return longest;
    }
}
