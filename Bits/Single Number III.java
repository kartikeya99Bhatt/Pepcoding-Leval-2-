class Solution {
    public int[] singleNumber(int[] nums) {
       
        int twonoxor=0;
        for(int val:nums)
            twonoxor^=val;
        
        int []ans=new int[2];
        int first=0;
        int secound=0;
        
        int rsb=(twonoxor&-twonoxor);
        for(int val:nums)
        {
            if((rsb&val)==0)
           first^=val;
            else
           secound^=val;
                
        }
        ans[0]=first;
        ans[1]=secound;
        return ans;
    }
}
