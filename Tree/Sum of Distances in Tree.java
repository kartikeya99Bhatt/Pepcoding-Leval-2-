class Solution {
    public int[] sumOfDistancesInTree(int n, int[][] edges) {
        HashSet<Integer>[]graph=new HashSet[n];
        for(int i=0;i<n;i++)
        {
            graph[i]=new HashSet<>();
        }
        for(int i=0;i<edges.length;i++)
        {
            int par=edges[i][0];
            int ch=edges[i][1];
            graph[par].add(ch);
            graph[ch].add(par);
        }
        
        int []node=new int[n];
        int []edge=new int[n];
        helper1(graph,0,-1,node,edge);
        helper2(graph,0,-1,node,edge);
        return edge;
    }
    public void helper2(HashSet<Integer>[]graph,int scr,int par,int []nodes,int []edges)
    {
        for(int nbr:graph[scr])
        {
            if(par!=nbr)
            {
             edges[nbr]=edges[scr]-(nodes[nbr])+(nodes.length-nodes[nbr]);
             helper2(graph,nbr,scr,nodes,edges);
            }
        }
    }
    public void helper1(HashSet<Integer>[]graph,int scr,int par,int []nodes,int []edges)
    {
        for(int nbr:graph[scr])
        {
            if(nbr!=par)
            {
                helper1(graph,nbr,scr,nodes,edges);
                nodes[scr]+=nodes[nbr];
                edges[scr]+=nodes[nbr]+edges[nbr];
            }
            
        }
        
        nodes[scr]++;
    }
}
