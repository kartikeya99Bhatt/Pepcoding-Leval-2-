class Solution {
    public int[] kthSmallestPrimeFraction(int[] nums, int k) {
        double lo=0.0;
        double hi=1.0;
       
        while(lo<hi)
        {
            double mid=(lo+hi)/2;
             int p=0;
            int q=1;
            // code
             int actual=0;
            int j=0;
            for(int i=0;i<nums.length;i++)
            {
                while(j<nums.length && nums[i]>mid*nums[j])
                {
                    j++;
                }
                if(j==nums.length)
                {
                    break;
                }
                actual+=(nums.length-j);
                
                if(nums[i]*q>p*nums[j])
                {
                    p=nums[i];
                    q=nums[j];
                }
            }
            // code completed for count
            if(actual>k)
            {
                hi=mid;
            }
            else if(actual<k)
            {
                lo=mid;
            }
            else
            {
                return (new int []{p,q});
            }
        }
        return (new int[0]);
    }
}
