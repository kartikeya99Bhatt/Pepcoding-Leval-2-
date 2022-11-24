class Solution {
    public int[] sortArrayByParity(int[] nums) {
        int j=0;int i=0;
         while(i<nums.length)
         {
            if(nums[i]%2==0)
            {
                int temp=nums[i];
                nums[i]=nums[j];
                nums[j]=temp;
                i++;
                j++;
            }
             else
             {
                 i++;
             }
        }
        return nums;
    }
}
