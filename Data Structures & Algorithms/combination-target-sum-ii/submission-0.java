class Solution {
     List<List<Integer>> res;
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        res = new ArrayList<>();
        List<Integer> subset = new ArrayList<>();

        dfs(candidates, target, 0, 0, subset);
        return res;
    }

    public void dfs(int[] candidates, int target, int j, int curSum, List<Integer> subset){
        if (curSum == target && !res.contains(subset)){
            res.add(new ArrayList<>(subset));
        }

        for (int i = j; i < candidates.length; i++){

            if (curSum + candidates[i] > target){
                return;
            }

            subset.add(candidates[i]);
            dfs(candidates, target, i + 1, curSum + candidates[i], subset);
            subset.remove(subset.size() - 1);
            dfs(candidates, target, i + 1, curSum, subset);
        }
    }
}
