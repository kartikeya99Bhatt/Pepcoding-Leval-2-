class Solution {
     static int  currCount=0;
     static boolean falg=false;
    public int numEnclaves(int[][] grid) 
    {
        int ans=0;
        boolean [][]visited=new boolean [grid.length][grid[0].length];
        for(int i=0;i<grid.length;i++)
        {
            for(int j=0;j<grid[0].length;j++)
            {
               
               if(visited[i][j]==false &&  grid[i][j]==1)
               {
                   currCount=0;
                   falg=false;
                   solve(i,j,visited,grid);
                   if(falg==false)
                   {
                       ans+=currCount;
                   }
               }
            }
        }
        return ans;
    }
    public void  solve(int row,int col,boolean [][]visited,int [][]grid)
    {
        if(row<0 || col<0 || row==grid.length || col==grid[0].length || visited[row][col]==true || grid[row][col]==0)
        {
            return ;
        }
        else if(row==0 || row==grid.length-1 || col==0 || col==grid[0].length-1)
        {
            falg=true;
        }
            
        currCount++;
        visited[row][col]=true;
        solve(row-1,col,visited,grid);
        solve(row+1,col,visited,grid);
        solve(row,col+1,visited,grid);
        solve(row,col-1,visited,grid);
    }
}
