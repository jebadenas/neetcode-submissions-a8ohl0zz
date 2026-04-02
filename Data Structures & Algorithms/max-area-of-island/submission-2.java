class Solution {
    int[][] offsets = new int[][]{{1,0}, {-1,0}, {0,1}, {0,-1}};

    public int maxAreaOfIsland(int[][] grid) {
        int res = 0;

        for (int y = 0; y < grid.length; y++){
            for (int x = 0; x < grid[0].length; x++){
                
                if (grid[y][x] == 1){
                    res = Math.max(res, bfs(grid, x, y));
                }
                
            }
        }

        return res;
    }

    public int bfs(int[][] grid, int x, int y){
        Queue<int[]> coordQ = new LinkedList<>();
        coordQ.offer(new int[]{y, x});
        grid[y][x] = 0;


        int area = 0;
        while (!coordQ.isEmpty()){
            int[] curCoords = coordQ.poll();
            area++;
            
            
            for (int[] offset: offsets){
                int yN = curCoords[0] + offset[0];
                int xN = curCoords[1] + offset[1];

                if (xN >= grid[0].length || xN < 0 || yN < 0 || yN >= grid.length ){
                    continue;
                }
                
                if (grid[yN][xN] == 0) continue;

                if (grid[yN][xN] == 1) {
                    coordQ.offer(new int[]{yN, xN});
                    grid[yN][xN] = 0;  
                }
            }
        }

        return area;

    }
}
