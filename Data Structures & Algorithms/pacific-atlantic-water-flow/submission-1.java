class Solution {
    int HEIGHT;
    int WIDTH;
    int[][] DIRS = new int[][]{{0,1},{0,-1},{1,0},{-1,0}};

    Set<int[]> pac = new HashSet<>();
    Set<int[]> atl = new HashSet<>();

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        HEIGHT = heights.length;
        WIDTH = heights[0].length;

        for (int y = 0; y < heights.length; y++){
            for (int x = 0; x < heights[y].length; x++){
                if (y == 0){
                    dfs(x, y, heights, pac);
                }
                if (y == heights.length - 1){
                    dfs(x, y, heights, atl);
                }

                if (x == 0){
                    dfs(x, y, heights, pac);
                }

                if (x == heights[y].length - 1){
                    dfs(x, y, heights, atl);
                }

                

            }
        } 

        List<List<Integer>> res = new ArrayList<>();
             
        for (int[] p : pac) {
    for (int[] a : atl) {
        if (p[0] == a[0] && p[1] == a[1]) {
            res.add(List.of(p[1], p[0])); // row, col format
            break;
        }
    }
}

        return res;
    }

    public void dfs(int x, int y, int[][] heights, Set<int[]> ocean){
        

        for (int[] p : ocean) {
        if (p[0] == x && p[1] == y) return; // already visited
    }
        ocean.add(new int[]{x,y});

        for (int[] dir: DIRS){
            int y1 = y + dir[1];
            int x1 = x + dir[0];

            if (y1 >= 0 && y1 < HEIGHT && x1 >= 0 && x1 < WIDTH && heights[y1][x1] >= heights[y][x]){
                dfs(x1, y1, heights, ocean);
            }
        }
        
    }
}
