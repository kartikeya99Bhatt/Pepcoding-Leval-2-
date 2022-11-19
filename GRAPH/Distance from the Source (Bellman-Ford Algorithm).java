class Solution {
    static int[] bellman_ford(int V, ArrayList<ArrayList<Integer>> edges, int S) {
        // Write your code here
        int []res=new int[V];
        Arrays.fill(res,100000000);
        res[S]=0;
        for(int i=1;i<V;i++)
        {
            for(ArrayList<Integer> list:edges){
                if(res[list.get(0)]==100000000){
                    continue;
                }
                else if( res[list.get(1)]>( res[list.get(0)]+list.get(2) ) )
                {
                    res[list.get(1)]=res[list.get(0)]+list.get(2);
                }
            }
        }
        
        // negative cycle detectaion
         for(ArrayList<Integer> list:edges){
                if(res[list.get(0)]==100000000){
                    continue;
                }
                else if( res[list.get(1)]>( res[list.get(0)]+list.get(2) ) )
                {
                    int []base={-1};
                    return (base);
                    
                }
            }
        
        //
        return res;
    }
}
