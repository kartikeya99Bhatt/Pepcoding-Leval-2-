class Solution {
    class Pair{
        int row;int col;int time;
        Pair(int row,int col,int time)
        {
            this.row=row;
            this.col=col;
            this.time=time;
        }
    }
    int maxTime=0;
    int countFreshOrange2=0;
    public int orangesRotting(int[][] grid) {
        int countFreshOrange=0;   
        
        Queue<Pair>q=new ArrayDeque<>();
        for(int i=0;i<grid.length;i++)
        {
            for(int j=0;j<grid[0].length;j++)
            {
                if(grid[i][j]==2)
                {
                    q.add(new Pair(i,j,0));
                }
                else if(grid[i][j]==1)
                {
                    countFreshOrange++;
                }
            }
        }
        solve(q,grid);
         return (countFreshOrange==countFreshOrange2)?maxTime:-1;
    }
    public void solve(Queue<Pair>q,int [][]grid)
    {
        int [][]dir={{-1,0},{1,0},{0,-1},{0,1}};
        boolean [][]visited=new boolean[grid.length][grid[0].length];
        while(q.size()>0)
        {
            //remove
            Pair temp=q.remove();
            //mark
            if(visited[temp.row][temp.col]==true)
            {
                continue;
            }
            visited[temp.row][temp.col]=true;
            if(grid[temp.row][temp.col]==1)
            countFreshOrange2++;
            //work
            maxTime=Math.max(maxTime,temp.time);
            //addchildern
            for(int i=0;i<dir.length;i++)
            {
                int row=temp.row+dir[i][0];
                int col=temp.col+dir[i][1];
                if(row>=0 && col>=0 && row<grid.length && col<grid[0].length && visited[row][col]==false && grid[row][col]==1)
                {
                    q.add(new Pair(row,col,temp.time+1));
                }
            }
        }
        
    }
}
/* 
remove
mark
work 
addchilderrn
*/
