class Solution {
    public int partitionDisjoint(int[] nums) {
        int pi=1;
        int mts=nums[0];
        int mtp=nums[0];
        
        for(int i=1;i<nums.length;i++)
        {
            mts=Math.max(nums[i],mts);
            if(nums[i]<mtp)
            {
                pi=i+1;
                mtp=mts;
            }
        }
        
        return pi;
    }
}
