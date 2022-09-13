// The TIME COMPLEXITY OF THIS CODE IS T(n)=O(n^2);
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

// The TIME COMPLEXITY OF THIS CODE IS T(n)=O(nlog(n))

class Solution {
    public int lengthOfLIS(int[] nums) {
        
        int []tail=new int[nums.length];
        tail[0]=nums[0];
        int len=1;
     
        for(int i=1;i<nums.length;i++)
        {
            if(tail[len-1]<nums[i])
            {
                tail[len]=nums[i];
                len++;
            }
            else
            {
                int idx=Arrays.binarySearch(tail,0,len-1,nums[i]);
                if(idx<0){
                    idx=idx*-1;
                    idx=idx-1;
                }
                tail[idx]=nums[i];
            }
        }
        return len;
    }
}
