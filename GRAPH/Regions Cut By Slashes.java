class Solution {
    int []parent;
    int []rank;
    public int regionsBySlashes(String[] grid) {
        
        parent=new int[grid.length*grid.length*4];
        rank=new int[grid.length*grid.length*4];
        
        for(int i=0;i<parent.length;i++)
        {
            parent[i]=i;
            rank[i]=0;
        }
        
        for(int i=0;i<grid.length;i++)
        {
            for(int j=0;j<grid.length;j++)
            {
                int bno=i*grid.length+j;
                char ch=grid[i].charAt(j);
                if(ch!='\\')
                {
                    unoinHelper(4*bno+0,4*bno+3);
                    unoinHelper(4*bno+1,4*bno+2);
                }
                if(ch!='/')
                {
                     unoinHelper(4*bno+0,4*bno+1);
                    unoinHelper(4*bno+2,4*bno+3);
                }
                
                // operation
                if(i>0)
                {
                    int obno=(i-1)*grid.length+j;
                    unoinHelper(4*bno+0,4*obno+2);
                }
                
                if(j>0)
                {
                   int obno=(i)*grid.length+j-1;
                   unoinHelper(4*bno+3,4*obno+1); 
                }
                
                if(i<grid.length-1)
                {
                   int obno=(i+1)*grid.length+j;
                   unoinHelper(4*bno+2,4*obno+0); 
                }
                if(j<grid.length-1)
                {
                   int obno=(i)*grid.length+j+1;
                   unoinHelper(4*bno+1,4*obno+3); 
                }
            }
        }
        int count=0;
        for(int i=0;i<parent.length;i++)
        {
            if(parent[i]==i)
            {
                count++;
            }
        }
        return count;
    }
    public int find(int x)
    {
        if(parent[x]==x)
        {
            return x;
        }
        else
        {
            int pofx=parent[x];
            int value=find(pofx);
            parent[x]=value;
            return value;
        }
    }
    public void unoinHelper(int x,int y)
    {
        int lofx=find(x);
        int lofy=find(y);
        if(lofx!=lofy)
        {
            union(lofx,lofy);
        }
    }
    public void union(int x,int y)
    {
        if(rank[x]<rank[y])
        {
            parent[x]=y;
        }
        else if(rank[y]<rank[x])
        {
            parent[y]=x;
        }
        else
        {
            parent[y]=x;
            rank[x]++;
        }
    }
}
