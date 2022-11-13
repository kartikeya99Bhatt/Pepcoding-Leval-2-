class Solution {
    int []parent;
    public int[] findRedundantDirectedConnection(int[][] edges) {
         int n=edges.length;
        parent=new int[n+1];
        Arrays.fill(parent,-1);
        boolean toParent=false;
        int []e1=new int[2];
        int []e2=new int[2];
        for(int i=0;i<edges.length;i++){
            int p=edges[i][0];
            int c=edges[i][1];
            if(parent[c]==-1)
            parent[c]=p;
            else{
                toParent=true;
                e2[0]=p;e2[1]=c;
                e1[0]=parent[c];e1[1]=c;
                break;
            }
        }
        System.out.println(toParent+"  "+"  "+e1[0]+"-"+e1[1]+" "+e2[0]+"-"+e2[1]);
        parent=new int[n+1];
        for(int i=0;i<=n;i++){
            parent[i]=i;
        }
        if(toParent==false)
        {
            // cycle detection case
            for(int i=0;i<edges.length;i++){
                int p=edges[i][0];
                int c=edges[i][1];
                int pofp=find(p);
                if(pofp==c)
                {
                   return edges[i];
                }
                else
                {
                    parent[c]=pofp;
                }
            }
            
        }
        else
        {
            for(int i=0;i<edges.length;i++){
                if(e2[0]==edges[i][0] && e2[1]==edges[i][1])
                {
                    continue;
                }
                int p=edges[i][0];
                int c=edges[i][1];
                int pofp=find(p);
                if(pofp==c)
                {
                   return e1;
                }
                else
                {
                   parent[c]=pofp;
                }
              }   
        }
        return e2; 
        
        
      //-------------------------------->
    }
    public int find(int x){
        if(parent[x]==x){
            return x;
        }
        int fp=find(parent[x]);
        return fp;
    }
}
