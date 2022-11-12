class Solution
{
    //Function to find if the given edge is a bridge in graph.
    static int time=0;
    static int res=0;
    static int isBridge(int V, ArrayList<ArrayList<Integer>> adj,int c,int d)
    {
        // code here
        res=0;
        time=0;
        boolean []visited=new boolean[V];
        int []low=new int[V];
        int []dis=new int[V];
        for(int i=0;i<V;i++){
            dfs(i,adj,c,d,visited,low,dis,-1);
        }
        return res;
    }
    public static void dfs(int scr,ArrayList<ArrayList<Integer>> adj,int c,int d,boolean [] visited,int [] low,int [] dis,int par)
    {
        visited[scr]=true;
        low[scr]=dis[scr]=++time;
        for(int nbr:adj.get(scr))
        {
            if(par==nbr){
                continue;
            }
            else if(visited[nbr]==true){
                low[scr]=Math.min(low[scr],dis[nbr]);
            }
            else{
                 dfs(nbr,adj,c,d,visited,low,dis,scr);
                 low[scr]=Math.min(low[scr],low[nbr]);
                  if(low[nbr]>dis[scr]){
                      if( (c==nbr &&  d==scr) || (c==scr && d==nbr) )
                      {
                          res=1;
                          return ;
                      }
                  }
            }
        }
    }
}
