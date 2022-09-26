class Solution {
    public int minAddToMakeValid(String s) {
        int count=0;
        Stack<Character>st=new Stack<>();
        for(char ch:s.toCharArray()){
            if(ch=='(' || ch=='{' || ch=='['){
                st.push(ch);
            }
            else 
            {
                if(st.size()>0 && ch==')')
                {
                    if(st.peek()=='(')
                    {
                        st.pop();
                    }
                }
                else if(st.size()>0 && ch=='}')
                {
                     if(st.peek()=='{')
                    {
                        st.pop();
                    }
                }
                else if(st.size()>0 && ch==']')
                {
                     if(st.peek()=='[')
                    {
                        st.pop();
                    }
                }
                else
                {
                    count++;
                }
            }
            
        }
        return(count+st.size());
    }
}
