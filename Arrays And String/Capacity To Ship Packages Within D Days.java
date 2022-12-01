class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int lo=0;int hi=0;
        
        for(int val:weights){
            lo=Math.max(val,lo);
             hi+=val;   
        }
        
        while(lo<hi)
        {
            int mid=lo+(hi-lo)/2;
            int partion=1;int sum=0;
            for(int i=0;i<weights.length;i++)
            {
                if((sum+weights[i])<=mid){
                    sum+=weights[i];
                }
                else{
                    sum=weights[i];
                    partion++;
                }
            }
            if(partion<=days)
            {
                hi=mid;
            }
            else
            {
                lo=mid+1;
            }
        }
        return lo;
    }
}
