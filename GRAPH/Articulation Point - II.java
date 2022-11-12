class Solution
{
    public int[] articulationPoints(int V, ArrayList<ArrayList<Integer>> adj)
    {
        // Code here
         boolean []aps=new boolean[V];
         boolean []visited=new boolean[V];
        int []low=new int[V];
        int []dis=new int[V];
        for(int i=0;i<V;i++){
            if(visited[i]==false)
            dfs(i,adj,low,dis,aps,-1,visited);
        }
        
        int cnt=0;
        for(int i=0;i<aps.length;i++){
            if(aps[i]==true){
                cnt++;
            }
        }
        if(cnt==0)
        {
            int []base={-1};
            return base;
        }
        int []ap=new int[cnt];
        int idx=0;
        for(int i=0;i<aps.length;i++){
             if(aps[i]==true){
               ap[idx++]=i;
            }
        }
        return ap;
    }
    static int time=0;
    public static void dfs(int scr,ArrayList<ArrayList<Integer>>adj,int []low,int []dis,boolean []aps,int par,boolean []visited)
    {
        int cld=0;
        visited[scr]=true;
        low[scr]=dis[scr]=++time;
        for(int nbr:adj.get(scr)){
           if(nbr==par){
               continue;
           }
           else if(visited[nbr]==true){
               low[scr]=Math.min(low[scr],dis[nbr]);
           }
           else{
               cld++;
               dfs(nbr,adj,low,dis,aps,scr,visited);
               low[scr]=Math.min(low[scr],low[nbr]);
               if(par!=-1 && dis[scr]<=low[nbr]){
                   aps[scr]=true;
               }
           }
        }
        if(par==-1 && cld>1){
            aps[scr]=true;
        }
    }
}
