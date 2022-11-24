class Solution {
    public int numPairsDivisibleBy60(int[] time) {
        int ans=0;
        int []arr=new int[60];
        for(int i=0;i<time.length;i++)
        {
            int rem=time[i]%60;
            if(rem==0 || rem==30)
            {
                arr[rem]++;
                ans+=arr[rem]-1;
            }
            else
            {
                arr[rem]++;
                ans+=arr[60-rem];
            }
            
        }
        
        return ans;
    }
}
