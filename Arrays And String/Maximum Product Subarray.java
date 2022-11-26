----------------------- APPROCH 1 SPACE=O(N)------------------
class Solution {
    public int maxProduct(int[] nums) {
        int []right=new int[nums.length];
        int mul=1;
        for(int i=nums.length-1;i>=0;i--)
        {
            if(nums[i]==0)
            {
                mul=1;
                right[i]=0;
            }
            else{
            mul*=nums[i];
            right[i]=mul;
            }
        }
        int left=1;
        int ans=Integer.MIN_VALUE;
        for(int i=0;i<nums.length;i++)
        {
            
            left*=nums[i];
            ans=(i<=nums.length-2)?Math.max(left,Math.max(ans,right[i+1])):Math.max(left,ans);
            if(left==0)
            {
                left=1;
            }
        }
        return ans;
    }
}


-------------------------------CONSTANT SPACE ------------------------
    class Solution {
    public int maxProduct(int[] nums) {
        int res=Integer.MIN_VALUE;
        int ps=1;
        for(int i=0;i<nums.length;i++)
        {
            ps*=nums[i];
            res=Math.max(res,ps);
            if(ps==0)
            {
                ps=1;
            }
        }
       int ss=1;
        for(int i=nums.length-1;i>=0;i--)
        {
             ss*=nums[i];
            res=Math.max(res,ss);
            if(ss==0)
            {
                ss=1;
            }
        }
        
        return res;
    }
}
