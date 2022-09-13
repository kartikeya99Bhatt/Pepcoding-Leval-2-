class Solution {
    int N;
    Random rand;
    HashMap<Integer,Integer>map;
    public Solution(int n, int[] blacklist) {
        N=n;
        rand=new Random();
        map=new HashMap<>();
        
        for(int i=0;i<blacklist.length;i++)
        {
            map.put(blacklist[i],-1);
        }
        int last=N-blacklist.length;
        int assign=last;
        for(int val:map.keySet())
        {
            if(val<last)
            {
                while(map.containsKey(assign)==true)
                {
                    assign++;
                }
                map.put(val,assign);
                assign++;
            }
        }
        
    }
    
    public int pick() {
        int val=rand.nextInt(N-map.size());
        if(map.containsKey(val))
        {
            val=map.get(val);
        }
        return val;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(n, blacklist);
 * int param_1 = obj.pick();
 */
