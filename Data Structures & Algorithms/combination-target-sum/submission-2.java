class Solution {
    List<List<Integer>> res;
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        res = new ArrayList<>();
        Arrays.sort(nums); //sorting the given num array
        dfs(0, new ArrayList<>(), 0, nums, target);
        return res;
    }

    private void dfs(int i, List<Integer> cur, int total, int[] nums, int target){
        if (total == target){
            res.add(new ArrayList<>(cur));
            return;
        }

        for (int j = i; j < nums.length; j++){
            if (total + nums[j] > target) {
                return; //we no longer have to keep calling because adding any number further down the list will be greater than the target
            }
            cur.add(nums[j]); //add the number to the subset
            dfs(j, cur, total + nums[j], nums, target); //call dfs with the new subset
            cur.remove(cur.size() - 1); //
        }
    } 
}
