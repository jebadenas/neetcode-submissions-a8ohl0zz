class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer,Integer> numbers = new HashMap<>();

        for (int i = 0; i < nums.length; i++){
            int current = nums[i];
            int difference = target - current;
            
            if (numbers.containsKey(difference)){
                return new int[] {numbers.get(difference), i};
            }

            numbers.put(current, i);
        }

        return new int[] {};
    }
}
