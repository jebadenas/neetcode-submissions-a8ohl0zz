class Solution {
    int[] cache;

    public int climbStairs(int n) {
        cache = new int[n];
        
        for (int i = 0; i < n; i++){
            cache[i] = -1;
        }

        return dfs(n, 0);
    }

    public int dfs(int n, int step){
        if (step == n){
            return 1;
        }

        if (step > n){
            return 0;
        }

        if (cache[step] != -1){
            return cache[step];
        }

        cache[step] = dfs(n, step + 1) + dfs(n, step + 2);

        return cache[step];

    }


}
