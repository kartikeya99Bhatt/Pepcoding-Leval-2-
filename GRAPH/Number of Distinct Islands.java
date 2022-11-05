class Solution {
    
    int countDistinctIslands(int[][] grid) {
        // Your Code here
        HashSet<String>set=new HashSet<>();
        boolean [][]visited=new boolean[grid.length][grid[0].length];
        for(int i=0;i<grid.length;i++)
        {
            for(int j=0;j<grid[0].length;j++)
            {
                if(visited[i][j]==false && grid[i][j]==1)
                {
                    StringBuilder sb=new StringBuilder();
                    solve(i,j,grid,visited,sb);
                 //   System.out.println(sb.toString());
                    set.add(sb.toString());
                }
            }
        }
        
        return set.size();
    }
    public void solve(int row,int col,int [][]grid,boolean [][]visited,StringBuilder sb)
    {
        
        visited[row][col]=true;
        if(row-1>=0 && visited[row-1][col]==false && grid[row-1][col]==1){
                 sb.append("N");
                 solve(row-1,col,grid,visited,sb);
        }
        if(row+1<grid.length && visited[row+1][col]==false && grid[row+1][col]==1){
                 sb.append("S");
                solve(row+1,col,grid,visited,sb);
        }
        if(col-1>=0 && visited[row][col-1]==false && grid[row][col-1]==1){
                 sb.append("E");
                 solve(row,col-1,grid,visited,sb);
        }
        if(col+1<grid[0].length && visited[row][col+1]==false && grid[row][col+1]==1){
                 sb.append("W");
                 solve(row,col+1,grid,visited,sb);
        }
        sb.append("B");
        
    }
}
