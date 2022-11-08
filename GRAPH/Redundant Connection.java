class Solution {
    int []parent;
    int []rank;
    public int[] findRedundantConnection(int[][] edges) {
        parent=new int[edges.length+1];
        rank=new int[edges.length+1];
        for(int i=0;i<=edges.length;i++){
            parent[i]=i;
            rank[i]=0;
        }
        int []ans=new int[2];
        for(int i=0;i<edges.length;i++)
        {
            int p1=find(edges[i][0]);
            int p2=find(edges[i][1]);
            if(p1!=p2)
            {
               union(p1,p2); 
            }
            else
            {
                ans[0]=edges[i][0];
                ans[1]=edges[i][1];    
            }
        }
        return ans;
    }
    public int find(int p1){
        if(parent[p1]==p1)
        {
            return p1;
        }
        parent[p1]=find(parent[p1]);
        return parent[p1];
    }
    public void union(int p1,int p2)
    {
        if(rank[p1]<rank[p2])
        {
            parent[p1]=p2;
        }
        else if(rank[p2]<rank[p1])
        {
            parent[p2]=p1;
        }
        else
        {
            parent[p2]=p1;
            rank[p1]++;
        }
    }
    
}
