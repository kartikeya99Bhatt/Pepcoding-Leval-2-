class Solution {
    int m;//row
    int n;//col
    public int[] hitBricks(int[][] grid, int[][] hits) {
        m=grid.length;
        n=grid[0].length;
        int toatlNodes=m*n+1;
        parent=new int[toatlNodes];
        rank=new int[toatlNodes];
        size=new int[toatlNodes];
        
        // initialize
        for(int i=0;i<toatlNodes;i++){
            parent[i]=i;
            rank[i]=0;
            size[i]=1;
        }
        // removeing the brick if exist
        //0->brick does'nt exist
        //1->brick exist
        //2->brick was exist but due to hit it has been removed
        for(int i=0;i<hits.length;i++){
            int hi=hits[i][0];
            int hj=hits[i][1];
            if(grid[hi][hj]==1){
                grid[hi][hj]=2;
            }
        }
        
        // union of all after removing
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==1){
                    unionAllNbr(grid,i,j);
                }
            }
        }
        int []res=new int[hits.length];
        for(int i=hits.length-1;i>=0;i--){
             int hi=hits[i][0];
             int hj=hits[i][1];
            if(grid[hi][hj]==2){
                int szwith0=size[find(0)];
                grid[hi][hj]=1;
                unionAllNbr(grid,hi,hj);
                int newszwith0=size[find(0)];
                if(newszwith0>szwith0){
                 res[i]=newszwith0-szwith0-1;
                }
                else
                {
                    res[i]=0;
                }
            }
           
            
        }
        
        return res;
        
    }
    int [][]dir={{1,0},{-1,0},{0,-1},{0,1}};
    public void unionAllNbr(int [][]grid,int i,int j){
        int oldbxno=i*n+j+1;
        for(int k=0;k<dir.length;k++){
            int row=dir[k][0]+i;
            int col=dir[k][1]+j;
            if(row>=0 && col>=0 && row<m && col<n && grid[row][col]==1){
                int newbxno=row*n+col+1;
                unionHelper(oldbxno,newbxno);
            }
        }
        if(i==0){
            unionHelper(0,oldbxno);
        }
    }
    int []parent;
    int []rank;
    int []size;

    public void unionHelper(int x,int y){
        int pofx=find(x);
        int pofy=find(y);
        if(pofx!=pofy){
            union(pofx,pofy);
        }
    }
    public int find(int x){
        if(parent[x]==x){
            return x;
        }
        parent[x]=find(parent[x]);
        return parent[x];
    }

    public void union(int x,int y){
        
         if(rank[x]<rank[y]){
            parent[x]=y;
            size[y]+=size[x];
        }
        else if(rank[y]<rank[x]){
            parent[y]=x;
            size[x]+=size[y];
        }
        else{
            parent[x]=y;
            size[y]+=size[x];
            rank[y]++;
        }
    }
    
}
