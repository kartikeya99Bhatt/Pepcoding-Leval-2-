class Solution {
    public int lengthOfLIS(int[] nums) {
        
        int []lis=new int[nums.length];
        lis[0]=1;
        for(int i=1;i<lis.length;i++){
            int max=0;
            for(int j=0;j<nums.length;j++){
                if(nums[j]<nums[i]){
                    max=Math.max(max,lis[j]);
                }
            }
            lis[i]=max+1;
        }
        
        int ans=0;
        for(int val:lis){
            ans=Math.max(ans,val);
        }
        return ans;
    }
}
