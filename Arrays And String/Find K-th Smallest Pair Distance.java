class Solution {
    public int smallestDistancePair(int[] nums, int k) {
        Arrays.sort(nums);
        int lo=Integer.MAX_VALUE;
        int hi=nums[nums.length-1]-nums[0];
        for(int i=1;i<nums.length;i++){
            lo=Math.min(nums[i]-nums[i-1],lo);
        }
        
        while(lo<hi)
        {
            int mid=(hi+lo)/2; // min Diffrence ke kitne element exist karte h 
            
            int count=0;int j=0;
            for(int i=0;i<nums.length;i++)
            {
                while(j<nums.length && nums[j]-nums[i]<=mid)
                {
                    j++;
                }
                count+=(j-i-1);
            }
            
            if(count>=k)
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
