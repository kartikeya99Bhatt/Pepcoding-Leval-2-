class GfG {
    // Function to reverse first k elements of a queue.
    public Queue<Integer> modifyQueue(Queue<Integer> q, int k) {
        // add code here.
        Stack<Integer>st=new Stack<>();
        
        for(int i=0;i<k;i++)
        {
            int val=q.remove();
            st.push(val);
        }
        int leftSize=q.size();
        while(st.size()>0)
        {
            q.add(st.pop());
        }
        for(int i=0;i<leftSize;i++)
        {
            q.add(q.remove());
        }
        return q;
    }
}
