class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int n=graph.length;
       
        int []visited=new int[n];
        for(int i=0;i<n;i++){
            if(visited[i]==0){
               dfs(i,visited,graph);
               
            }
        }
        ArrayList<Integer>ans=new ArrayList<>();
        int idx=0;
        for(int val:visited){
            if(val==2)
                ans.add(idx);
            idx++;
        }
        return ans;
    }
    public int dfs(int scr,int []visited,int [][]graph){
         visited[scr]=1;
        for(int nbr:graph[scr]){
            if(visited[nbr]==0)
            {
                  int res=dfs(nbr,visited,graph);
                    if(res==1)
                    {
                       visited[scr]=1;
                        return 1;
                    }
            }
            else if(visited[nbr]==1)
            {
                return visited[nbr];
            }
        }
        visited[scr]=2;
        return 2;
    }
}
