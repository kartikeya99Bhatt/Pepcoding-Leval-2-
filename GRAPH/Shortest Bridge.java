class Solution {
    class Pair{
        int row;
        int col;
        int leval;
        Pair(int row,int col,int leval)
        {
            this.row=row;
            this.col=col;
            this.leval=leval;
        }
    }
    int [][]dir={{-1,0},{1,0},{0,-1},{0,1}};
    public int shortestBridge(int[][] grid) {
         // I part
        boolean found=false;
        boolean [][]visited=new boolean[grid.length][grid.length];
        boolean [][]visited2=new boolean[grid.length][grid.length];
        Queue<Pair>q=new ArrayDeque<>();
        for(int i=0;i<grid.length;i++)
        {
            for(int j=0;j<grid[i].length;j++)
            {
                if(grid[i][j]==1)
                {
                    found=true;
                    dfs(i,j,grid,visited,q);
                }
                if(found){break;}
            }
             if(found){break;}
        }
        // II part
        while(q.size()>0)
        {
            //remove
            Pair temp=q.remove();
            // mark
            if(visited2[temp.row][temp.col]==true)
            {
                continue;
            }
            visited2[temp.row][temp.col]=true;
            //work
            if(grid[temp.row][temp.col]==1 && temp.leval>0)
            {
                return (temp.leval-1);
            }
            //children
             for(int i=0;i<dir.length;i++)
            {
                int newRow=temp.row+dir[i][0];
                int newCol=temp.col+dir[i][1];
                if(newRow>=0 && newCol>=0 && newRow<grid.length && newCol<grid.length  && visited[newRow][newCol]==false && visited2[newRow][newCol]==false)
                {
                   q.add(new Pair(newRow,newCol,temp.leval+1));
                }
            }
        }
        return 0;
        
    }
    public void dfs(int row,int col,int [][] grid,boolean [][]visited,Queue<Pair>q){
        visited[row][col]=true;
        q.add(new Pair(row,col,0));
        for(int i=0;i<dir.length;i++)
        {
            int newRow=row+dir[i][0];
            int newCol=col+dir[i][1];
            if(newRow>=0 && newCol>=0 && newRow<grid.length && newCol<grid.length && grid[newRow][newCol]==1 && visited[newRow][newCol]==false)
            {
                dfs(newRow,newCol,grid,visited,q);
            }
        }
    }
}
