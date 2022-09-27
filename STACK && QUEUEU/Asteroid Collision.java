class Solution {
    public int[] asteroidCollision(int[] asteroids) {
     Stack<Integer>st=new Stack<>();
        for(int val:asteroids)
        {
            if(st.size()==0)
            {
                st.push(val);
            }
            else if(val>0)
            {
                 st.push(val);
            }
            else if(st.peek()<0)
            {
                 st.push(val);
            }
            else
            {
                while(st.size()>0 && st.peek()>0 && st.peek()<Math.abs(val))
                {
                        st.pop();
                }
                if(st.size()==0)
                {
                    st.push(val); 
                }
                else if(st.peek()<0)
                {
                     st.push(val);
                }
                else if(st.peek()==Math.abs(val))
                {
                     st.pop();
                }
                  else if(st.peek()>Math.abs(val))
                 {

                 }
               
            }
          
            
        }
        int []ans=new int[st.size()];
        int idx=st.size()-1;
        while(st.size()>0)
        {
            ans[idx--]=st.pop();
        }
        return ans;
    }
}
