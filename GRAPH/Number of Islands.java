class Solution {
    public int numIslands(char[][] grid) {
        int count =0;
        boolean [][]visited=new boolean [grid.length][grid[0].length];
        for(int i=0;i<grid.length;i++)
        {
            for(int j=0;j<grid[0].length;j++)
            {
                if(grid[i][j]=='1' && visited[i][j]==false)
                {
                    solve(i,j,grid,visited);
                    count++;
                }
            }
        }
        return count;
    }
    public void solve(int row,int col,char [][]grid,boolean [][]visited)
    {
        if(row<0 || row==grid.length || col<0 || col==grid[0].length || visited[row][col]==true || grid[row][col]=='0')
        {
            return ;
        }
        visited[row][col]=true;
        solve(row-1,col,grid,visited);
        solve(row+1,col,grid,visited);
        solve(row,col-1,grid,visited);
        solve(row,col+1,grid,visited);
    }
}
