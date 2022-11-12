class Solution {
    public int[] findRedundantDirectedConnection(int[][] edges) {
       
        int []parent=new int[edges.length+1];
        Arrays.fill(parent,-1);
        
        int []e1=null;
        int []e2=null;
        
        boolean twopar=false;
        for(int i=0;i<edges.length;i++)
        {
            int from=edges[i][0];
            int to=edges[i][1];
            if(parent[to]==-1)
            parent[to]=from;
            else
            {
                e2=edges[i];
                e1=new int[]{parent[to],to};
                twopar=true;
                break;
                
            }
            
        }
        
//Now we need to Handle Three Cases
        dsu=new int[edges.length+1];
        boolean noCycleIsPresent=true;
        int []res=null;
        for(int i=0;i<dsu.length;i++)
        {
            dsu[i]=i;
        }
        if(twopar==false)
        {
            for(int i=0;i<edges.length;i++)
            {
                int from=edges[i][0];
                int to=edges[i][1];
                
                int pofrom=find(from);
                if(pofrom==to)
                {
                    res=edges[i];
                    break;
                }
                else
                {
                    dsu[to]=pofrom;
                }
                
            }
            return res;
        }
        else
        {
            for(int i=0;i<edges.length;i++)
            {
                if(edges[i]==e2)
                {
                    continue;
                }
                int from=edges[i][0];
                int to=edges[i][1];
                
                int pofrom=find(from);
                
                if(pofrom==to)
                {
                    noCycleIsPresent=false;
                    break;
                }
                else
                {
                   dsu[to]=pofrom; 
                }
            }
            if(noCycleIsPresent==true)
            {
                return e2;
            }
            else
            {
                return e1;
            }
        }
    }
    
    int []dsu;
    public int find(int x){
        if(dsu[x]==x)
        {
            return x;
        }
        else
        {
            int pofx=dsu[x];
            int value=find(pofx);
            return value;
        }
    }
}
