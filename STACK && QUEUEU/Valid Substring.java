class Solution {
    static int findMaxLen(String s) {
        // code here
        int res=0;
        Stack<Integer>st=new Stack<>();
        st.push(-1);
        for(int i=0;i<s.length();i++)
        {
           char ch=s.charAt(i);
            if(ch=='(')
            {
                st.push(i);
            }
            else
            {
                st.pop();
                if(st.size()>0)
                {
                    int curr=i-st.peek();
                    res=Math.max(res,curr);
                }
                else 
                {
                    st.push(i);
                }
            }
        }
        return res;
    }
};
