class Solution {
    public int maxNumEdgesToRemove(int n, int[][] edges)
    {
        int [] parent1=new int[n+1];
        int [] rank1=new int[n+1];
        int [] parent2=new int[n+1];
        int [] rank2=new int[n+1];
        for(int i=0;i<=n;i++){
            parent1[i]=i;
            rank1[i]=0;
            parent2[i]=i;
            rank2[i]=0;
        }
        int e1=0;
        int e2=0;
        int count=0;
        for(int i=0;i<edges.length;i++)
        {
            int type=edges[i][0];
            int x=edges[i][1];
            int y=edges[i][2];
            if(type==3){
              int pofx=find(x,parent1);
              int pofy=find(y,parent1);
              if(pofx!=pofy)
              {
                  union(pofx,pofy,parent1,rank1);
                  union(pofx,pofy,parent2,rank2);
                  e1++;
                  e2++;
              }
              else
              {
                  count++;
              }
            }
        }
        
         for(int i=0;i<edges.length;i++)
        {
            int type=edges[i][0];
            int x=edges[i][1];
            int y=edges[i][2];
            if(type==1)
            {
              int pofx=find(x,parent1);
              int pofy=find(y,parent1);
              if(pofx!=pofy)
              {
                  union(pofx,pofy,parent1,rank1);
                  e1++;
              }
              else
              {
                  count++;
              }
            }
               else if(type==2)
             {
              int pofx=find(x,parent2);
              int pofy=find(y,parent2);
              if(pofx!=pofy)
              {
                  union(pofx,pofy,parent2,rank2);
                  e2++;
              }
              else
              {
                  count++;
              }
            }
        }
        
        if(e1!=n-1 || e2!=n-1){
            return -1;
        }
        return count;

        
    }
   
    public int find(int x,int []parent){
        if(parent[x]==x){
            return x;
        }
        parent[x]=find(parent[x],parent);
        return parent[x];
    }
   public void union(int x,int y,int []parent,int []rank){
       if(rank[x]<rank[y]){
           parent[x]=y;
       }
       else if(rank[y]<rank[x]){
           parent[y]=x;
       }
       else{
            parent[x]=y;
            rank[y]++;
       }
   }
}
