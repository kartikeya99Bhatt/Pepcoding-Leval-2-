class Solution {
    class Pair implements Comparable<Pair>
    {
        int row;
        int col;
        int time;
        Pair(int row,int col,int time)
        {
            this.row=row;
            this.col=col;
            this.time=time;
        }
        public int compareTo(Pair o)
        {
            return (this.time-o.time);
        }
    }
    public int swimInWater(int[][] grid) {
        PriorityQueue<Pair>pq=new PriorityQueue();
        pq.add(new Pair(0,0,grid[0][0]));
        
        int [][]dir={{-1,0},{1,0},{0,-1},{0,1}};
        boolean [][]visited=new boolean[grid.length][grid.length];

        while(pq.size()>0)
        {
            Pair temp=pq.remove();
            if(visited[temp.row][temp.col]==true)
            {
                continue;
            }
            visited[temp.row][temp.col]=true;
            if(temp.row==grid.length-1 && temp.col==grid.length-1)
            {
                return temp.time;
            }
            for(int i=0;i<dir.length;i++)
            {
                int row=temp.row+dir[i][0];
                int col=temp.col+dir[i][1];
                if(row>=0 && col>=0 && row<grid.length && col<grid.length && visited[row][col]==false)
                {
                    pq.add(new Pair(row,col,Math.max(grid[row][col],temp.time)));
                }
            }
            
        }
        return -1;
    }
}
