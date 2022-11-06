class Solution
{
    //Function to find a Mother Vertex in the Graph.
    static int count=0;
    public int findMotherVertex(int V, ArrayList<ArrayList<Integer>>adj)
    {
        // Code here
        int mv=-1;
        for(int i=0;i<V;i++)
        {
             count=0;
            dfs(i,adj,new boolean[V]);
            if(count==V)
            {
                mv=i;
                break;
            }
        }
        
        return mv;
    }
    public static void dfs(int scr,ArrayList<ArrayList<Integer>>adj,boolean []visited)
    {
        visited[scr]=true;
        count++;
        for(int nbr:adj.get(scr))
        {
            if(visited[nbr]==false)
            {
                dfs(nbr,adj,visited);
            }
        }
    }
}
