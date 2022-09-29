class MinStack {

     Stack<Long>st;
     Long min;
    public MinStack() {
        st=new Stack<>();
        min=Long.MAX_VALUE;
    }
    
    public void push(int val1) {
        long val=val1;
        if(st.size()==0)
        {
            st.push(val);
            min=val;
        }
        else if(val>min)
        {
            st.push(val);
        }
        else
        {
           st.push(2*val-min);
            min=val;
        }
    }
    
    public void pop() {
        if(st.peek()<min)
        {
            min=2*min-st.peek();
            st.pop();
        }
        else
        {
            st.pop();
        }
    }
    
    public int top() {
        if(st.peek()<min)
        {
            return min.intValue();
        }
        else
        {
            return(st.peek().intValue());
        }
    }
    
    public int getMin() {
        return(min).intValue();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
