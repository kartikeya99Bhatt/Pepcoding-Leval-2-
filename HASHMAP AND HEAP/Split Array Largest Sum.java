class Solution {
    public int splitArray(int[] nums, int k) {
        int lo=0;
        int hi=0;
        for(int val:nums){
            lo=Math.max(val,lo);
            hi+=val;
        }
        
        while(lo<hi)
        {
            int mid=lo-(lo-hi)/2;
            int partion=1;
            int partionSum=0;
            for(int i=0;i<nums.length;i++)
            {
                if(partionSum+nums[i]<=mid)
                {
                    partionSum+=nums[i];
                }
                else
                {
                    partion++;
                    partionSum=nums[i];
                }
            }
             System.out.println(mid);
            if(partion>k)
            {
                lo=mid+1;
            }
            else 
            {
                hi=mid;
            }
           
        }
        return lo;
    }
}
