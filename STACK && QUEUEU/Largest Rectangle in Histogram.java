class Solution {
    public int largestRectangleArea(int[] heights) {
        
        int []right=RS(heights);
       int []left=LS(heights);
        
        int ans=0;
        for(int i=0;i<right.length;i++){
            System.out.println(right[i]);
          ans=Math.max(ans,heights[i]*(right[i]-left[i]-1));
        }
        return ans;
    }
    public int [] RS(int []ht)
    {
        int []ans=new int[ht.length];
        Stack<Integer>st=new Stack<>();
        Arrays.fill(ans,ht.length);
        for(int i=ht.length-1;i>=0;i--){
            while(st.size()>0 && ht[st.peek()]>=ht[i]){
                st.pop();
            }
            if(st.size()>0){
                ans[i]=st.peek();
            }
            st.push(i);
        }
        return ans;
    }
    
    public int []LS(int []ht)
    {
        int []ans=new int[ht.length];
        Stack<Integer>st=new Stack<>();
        Arrays.fill(ans,-1);
        for(int i=0;i<ht.length;i++)
        {
            while(st.size()>0 && ht[st.peek()]>=ht[i]){
                st.pop();
            }
            if(st.size()>0){
                ans[i]=st.peek();
            }
            st.push(i);
        }
        return ans;
    }
}
