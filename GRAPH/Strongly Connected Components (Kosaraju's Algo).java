class Solution
{
    //Function to find number of strongly connected components in the graph.
    public int kosaraju(int V, ArrayList<ArrayList<Integer>> adj)
    {
        //code here
        // Ist part
        Stack<Integer>st=new Stack<>();
        boolean []visited=new boolean [V];
        for(int i=0;i<V;i++)
        {
            if(visited[i]==false)
            {
                dfs1(i,adj,visited,st);
            }
        }
        
        // II part
        ArrayList<ArrayList<Integer>>newAdj=new ArrayList<>();
        for(int i=0;i<V;i++)
        {
            newAdj.add(new ArrayList<>());
        }
        for(int i=0;i<V;i++)
        {
            for(int val:adj.get(i))
            {
                newAdj.get(val).add(i);
            }
        }
        
        //III rd part
        int count=0;
        visited =new boolean[V];
        while(st.size()>0)
        {
           int scr=st.pop();
           if(visited[scr]==false)
           {count++;
               dfs2(scr,newAdj,visited);
           }
        }
        return count;
    }
    public  void dfs1(int scr,ArrayList<ArrayList<Integer>>adj,boolean []visited,Stack<Integer>st){
        visited[scr]=true;
        for(int nbr:adj.get(scr))
        {
            if(visited[nbr]==false)
            {
                dfs1(nbr,adj,visited,st);
            }
        }
        st.add(scr);
    }
    public void dfs2(int scr,ArrayList<ArrayList<Integer>>adj,boolean []visited)
    {
        visited[scr]=true;
        for(int nbr:adj.get(scr))
        {
            if(visited[nbr]==false)
            {
                dfs2(nbr,adj,visited);
            }
        }
    }
}
