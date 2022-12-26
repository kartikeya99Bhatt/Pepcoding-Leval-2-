public int findMaxConsecutiveOnes(int[] nums) {
        // write your code here
        int i=0;
       boolean flag =false;
       int ans=0;
        for(int j=0;j<nums.length;j++){
            if(flag==true && nums[j]==0)
            {
               while(nums[i]!=0)
               {
                   i++;
               }
               i++;
               flag=false;
            }
            if(nums[j]==0)
            {
               flag=true;
            }
            ans=Math.max(ans,(j-i+1));
        }
        return ans;
    }
