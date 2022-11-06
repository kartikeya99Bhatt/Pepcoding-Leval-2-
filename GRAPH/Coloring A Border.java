class Solution {
    int [][]dir={{-1,0},{1,0},{0,-1},{0,1}};
    public int[][] colorBorder(int[][] grid, int row, int col, int color){
        boolean [][]ans=new boolean[grid.length][grid[0].length];
        solve(row,col,new boolean[grid.length][grid[0].length],grid,grid[row][col],ans);
        for(int i=0;i<ans.length;i++)
        {
            for(int j=0;j<ans[i].length;j++)
            {
                grid[i][j]=(ans[i][j]==true)?color:grid[i][j];
            }
        }
        return grid;
    }
    public void solve(int row,int col,boolean [][]visited,int [][]grid,int val,boolean [][]ans)
    {
        visited[row][col]=true;
        if(checkIAmborder(row,col,grid,val))
        {
            ans[row][col]=true;
        }
        for(int i=0;i<dir.length;i++)
        {
            int newRow=row+dir[i][0];
            int newCol=col+dir[i][1];
            if(newRow>=0 && newCol>=0 && newRow<grid.length && newCol<grid[0].length && grid[newRow][newCol]==val && visited[newRow][newCol]==false)
            {
                solve(newRow,newCol,visited,grid,val,ans);
            }
        }
    }
    public boolean checkIAmborder(int row,int col,int [][]grid,int val)
    {
        
        if(row==0 || row==grid.length-1 || col==0 || col==grid[0].length-1)
        {
            return true;
        }
        else
        {
            for(int i=0;i<dir.length;i++)
            {
                int newRow=row+dir[i][0];
                int newCol=col+dir[i][1];
                if(newRow>=0 && newCol>=0 && newRow<grid.length && newCol<grid[0].length && grid[newRow][newCol]!=val)
                {
                   return true;
                }
            }
        }
        return false;
    }
}
