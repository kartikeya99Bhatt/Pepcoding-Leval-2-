class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        
        Stack<Integer>st=new Stack<Integer>();
        int []nge=new int[nums.length];
        for(int i=nums.length-1;i>=0;i--)
        {
            int value=nums[i];
            while(st.size()>0 && nums[st.peek()]<=value)
            {
                st.pop();
            }
            if(st.size()==0)
            {
                nge[i]=-1;
            }
            else
            {
                 nge[i]=st.peek();
            }
            st.push(i);
        }
        
        int []ans=new int[nums.length-k+1];
        
        int i=0;
        int idx=0;
        int range=0;
        while(i<ans.length)
        {
            if(idx<i)
            {
                idx=i;
            }
            range=i+k-1;
            while( nge[idx] !=-1 && nge[idx]<=range)
            {
                idx=nge[idx];
            }
            ans[i]=nums[idx];
            i++;
        }
        return ans;
    }
}

