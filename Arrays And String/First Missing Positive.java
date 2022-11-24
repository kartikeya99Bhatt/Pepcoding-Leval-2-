class Solution {
    public int firstMissingPositive(int[] nums) {
        for(int i=0;i<nums.length;i++){
            if(nums[i]<=0 || nums[i]>nums.length)
            {
                nums[i]=nums.length+1;
            }
        }
        for(int i=0;i<nums.length;i++)
        {
            int idx=Math.abs(nums[i]);
            if(idx!=(nums.length+1) && nums[idx-1]>0){
                nums[idx-1]=nums[idx-1]*-1;
            }
        }

        for(int i=0;i<nums.length;i++)
        {
            if(nums[i]>0)
            {
                return (i+1);
            }
        }
        return nums.length+1;
    }
}
