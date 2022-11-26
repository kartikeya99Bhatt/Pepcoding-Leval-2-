class Solution {
    public int trap(int[] height) {
        int []right=new int[height.length];
        int max=0;
        for(int i=height.length-1;i>=0;i--)
        {
            right[i]=max=Math.max(max,height[i]);
        }
        max=0;
        int ans=0;
        for(int i=0;i<height.length;i++)
        {
            max=Math.max(max,height[i]);
            int currMin=Math.min(max,right[i]);
            ans+=currMin-height[i];
        }
        return ans;
    }
}
