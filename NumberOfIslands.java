public class NumberOfIslands {
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }
        
        int length = grid.length;
        int width = grid[0].length;
        int count = 0;
        
        for (int i=0; i<length; i++) {
            for (int j=0; j<width; j++) {
                if (grid[i][j] == '1') {
                    count ++;
                    mark(grid, i, j);
                }
            }
        }
        return count;
    }
    
    private void mark(char[][] grid, int startx, int starty) {
        if (startx >= grid.length || starty >= grid[0].length || startx < 0 || starty < 0) {
            return;
        }
        if (grid[startx][starty] != '1') {
            return;
        }
        
        grid[startx][starty] = '2';
        mark(grid, startx+1, starty);
        mark(grid, startx-1, starty);
        mark(grid, startx, starty+1);
        mark(grid, startx, starty-1);
    }
}
