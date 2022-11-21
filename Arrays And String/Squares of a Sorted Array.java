class Solution {
    public int[] sortedSquares(int[] nums) {
        int []ans=new int[nums.length];
        int lo=0;int hi=nums.length-1;
        int idx=hi;
        while(lo<=hi){
            if(Math.abs(nums[hi])>Math.abs(nums[lo])){
                ans[idx--]=(int)Math.pow(nums[hi],2);
                hi--;
            }
            else{
                 ans[idx--]=(int)Math.pow(nums[lo],2);
                lo++;
            }
        }
        return ans;
    }
}
