class Solution {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer>st=new Stack<>();
        st.push(pushed[0]);
        int i=1;int j=0;
        while(i<pushed.length)
        {
            if(st.size()==0 || popped[j]!=st.peek())
            {
                st.push(pushed[i]);
                i++;
            }
            else
            {
                 while( st.size()>0 && popped[j]==st.peek())
                {
                    st.pop();
                     j++;
                }
            }
        }
        
        while(j<popped.length && popped[j]==st.peek())
        {
            st.pop();
             j++;
        }
        
        return (st.size()==0);
    }
}
