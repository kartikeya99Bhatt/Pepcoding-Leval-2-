class Solution {
    public int smallestDivisor(int[] nums, int threshold) {
        int max=0;
        for(int val:nums){
            max=Math.max(val,max);
        }
        int hi=max; int lo=1;
        int minDiv=0;
        while(lo<=hi)
        {
            int mid=(lo+hi)/2;
            int currSum=0;
            for(int val:nums)
            {
                currSum+=Math.ceil(val*1.0/mid);
            }
            if(currSum<=threshold)
            {
                minDiv=mid;
                hi=mid-1;
            }
            else
            {
                lo=mid+1;
            }
        }
        return minDiv;
    }
}
