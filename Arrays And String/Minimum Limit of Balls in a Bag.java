class Solution {
    public int minimumSize(int[] nums, int maxOperations) {
        int lo=1;
        int hi=0;
        for(int val:nums){
            hi=Math.max(hi,val);
        }
        while(lo<hi)
        {
            int mid=(lo+hi)/2;
            int operation=0;
            for(int i=0;i<nums.length;i++){
              if(nums[i]>mid)
              {
                  int spare=nums[i]-mid;
                  int op=(int)Math.ceil(spare*1.0/mid);
                  operation+=op;
              }
            }
            if(operation<=maxOperations)
            {
              hi=mid;    
            }
            else
            {
                lo=mid+1;
            }
        }
        return lo;
    }
}
