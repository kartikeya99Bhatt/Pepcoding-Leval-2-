class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int res=0;
        for(int i=0;i<gas.length;i++)
        {
            res+=(gas[i]-cost[i]);
        }
        if(res<0)
        {
            return -1;
        }
        
        int ansidx=0;
        int ans=0;
        for(int i=0;i<gas.length;i++)
        {
            if(ans<0)
            {
                ans=0;
                ansidx=i;
            }
            ans+=(gas[i]-cost[i]);
        }
        return ansidx;
    }
}
