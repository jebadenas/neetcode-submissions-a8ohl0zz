// find all rotten oranges and normal organges for references
// add all rotten oranges into a queue
// run bfs 

//iterate across the rotten orangs indexes and see if they are all rotten

class Solution {
    public int orangesRotting(int[][] grid) {


        int res = 0;

        int[][] dirs = new int[][]{{0,1},{0,-1},{1,0},{-1,0}};
    
        List<int[]> fresh = new ArrayList<>();

        Queue<int[]> q = new LinkedList<>();

        for (int y = 0; y < grid.length; y++){
            for (int x = 0; x < grid[y].length; x++){
                int spot = grid[y][x];

                if (spot == 1){
                    fresh.add(new int[]{x, y});
                }

                if (spot == 2){
                    q.add(new int[]{x, y});
                }
            }
        }

        while (!q.isEmpty()){
            int size = q.size();
            boolean anyNew = false;

            for (int i = 0; i < size; i++){
                int[] point = q.poll();
                int x = point[0];
                int y = point[1];

                for (int[] dir: dirs){
                    int x1 = x + dir[0];
                    int y1 = y + dir[1];

                    if (y1 >= 0 && y1 < grid.length && x1 >= 0 && x1 < grid[y1].length && grid[y1][x1] == 1){
                        grid[y1][x1] = 2;
                        q.add(new int[]{x1,y1});
                        anyNew = true;
                    }
                }
            }

            if (anyNew) res++;
        
        }

        for (int[] fruit: fresh){
            int x = fruit[0];
            int y = fruit[1];

            if (grid[y][x] == 1){
                return -1;
            }
        }


        return res;
        
    }
}
