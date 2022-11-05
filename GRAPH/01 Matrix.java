class Solution {
    class Pair
    {
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
    public int[][] updateMatrix(int[][] mat) {
       
        Queue<Pair>pq=new ArrayDeque<>();
        
        for(int i=0;i<mat.length;i++){
            for(int j=0;j<mat[i].length;j++){
                if(mat[i][j]==0){
                    pq.add(new Pair(i,j,0));
                }
            }
        }
        int [][]dir={{-1,0},{1,0},{0,-1},{0,1}};
        int [][]ans=new int[mat.length][mat[0].length];
        boolean [][]visited=new boolean[mat.length][mat[0].length];
        while(pq.size()>0)
        {
            //remove
            Pair temp=pq.remove();
            // mark*
            if(visited[temp.row][temp.col]==true)
            {
                continue;
            }
            visited[temp.row][temp.col]=true;
            // work
            ans[temp.row][temp.col]=temp.leval;
            // addchildren*
            for(int i=0;i<dir.length;i++)
            {
                int row=temp.row+dir[i][0];
                int col=temp.col+dir[i][1];
                if(row>=0 && col>=0 && row<mat.length && col<mat[0].length)
                {
                    pq.add(new Pair(row,col,temp.leval+1));
                }
            }
        }
        return ans;
    }
}
