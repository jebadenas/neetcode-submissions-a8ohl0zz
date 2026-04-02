class Solution {
    int res = 0;
    Queue<int[]> landQ = new LinkedList<>();

    public int numIslands(char[][] grid) {

        for (int y = 0; y < grid.length; y++){
            for (int x = 0; x < grid[0].length; x++){
                if (grid[y][x] == '1'){
                    landQ.offer(new int[]{y,x});
                }
            }
        }

        while (!landQ.isEmpty()){
            int[] coords = landQ.poll();

            if (grid[coords[0]][coords[1]] == '1'){
                dfs(grid, coords);
                res++;
            }
        }

        return res;

        
    }

    public void dfs(char[][] grid, int[] coords){
        if (coords[0] < 0 || coords[0] >= grid.length || coords[1] < 0 || coords[1] >= grid[0].length) return;

        if (grid[coords[0]][coords[1]] == '0') return;

        grid[coords[0]][coords[1]] = '0';
        dfs(grid, new int[]{coords[0]+1, coords[1]});
        dfs(grid, new int[]{coords[0]-1, coords[1]});
        dfs(grid, new int[]{coords[0], coords[1]+1});
        dfs(grid, new int[]{coords[0], coords[1]-1});

    }
}
