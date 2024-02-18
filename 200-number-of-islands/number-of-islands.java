class Solution {
    private int dfs(char[][] grid, boolean visited[][], int i, int j){
        int rows = grid.length;
        int cols = grid[0].length;

        if( i < 0 || j < 0 || i >= rows || j >= cols || visited[i][j]) return 0;

        visited[i][j] = true;
        
        if(grid[i][j] == '1'){
            return 1 + dfs(grid, visited, i+1, j)
                    +  dfs(grid, visited, i-1, j)
                    +  dfs(grid, visited, i, j+1)
                    +  dfs(grid, visited, i, j-1);
        }
        else return 0;
    }
    public int numIslands(char[][] grid) {
        
        int row = grid.length;
        int col = grid[0].length;

        boolean visited[][] = new boolean[row][col];

        int count = 0;

        for(int i=0;i < row; i++){
            for(int j=0; j< col; j++){
                int result = dfs(grid, visited, i, j);
                if(result > 0) count++;
            }
        }

        return count;
    }
}