class Solution
{
    public int isEularCircuitExist(int V, ArrayList<ArrayList<Integer>> adj)
    {
        // Code here
        int oddCount=0;
        for(int i=0;i<V;i++){
            int size=adj.get(i).size();
            if(size%2==1){
                oddCount++;
            }
        }
        if(oddCount==0)
            return 2;
        else if(oddCount==2)
        return 1;
        else
        return 0;
    }
}
