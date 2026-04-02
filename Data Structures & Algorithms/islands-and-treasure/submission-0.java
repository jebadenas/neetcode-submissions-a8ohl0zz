class Solution {
    public void islandsAndTreasure(int[][] grid) {
        int INF = 2147483647;

        int ROWS = grid.length;
        int COLS = grid[0].length;

        Queue<int[]> q = new LinkedList<>();

        for (int i = 0; i < grid.length; i++){
            for (int j = 0; j < grid[i].length; j++){
                if (grid[i][j] == 0){
                    q.add(new int[]{j,i});
                }
            }
        }

        int[][] dirs = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

        int steps = 1;

        while (!q.isEmpty()){
            int size = q.size();

            for (int i = 0; i < size; i++){
                int[] curPoint = q.poll();

                for (int[] dir: dirs){
                    int x = curPoint[0] + dir[0];
                    int y = curPoint[1] + dir[1];

                    if (y < 0 || y >= ROWS || x < 0 || x > COLS - 1 || grid[y][x] != INF){
                        continue;
                    }

                    grid[y][x] = steps;
                    q.add(new int[]{x,y});
                }
            }

            steps++;
        }

        return;
    }
}
