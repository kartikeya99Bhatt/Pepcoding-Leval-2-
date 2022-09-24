class Solution {
    class Pair{
        int idx;
         int val;
        Pair(int idx,int val){
            this.idx=idx;
            this.val=val;
        }
    }
    public int[] dailyTemperatures(int[] temperatures) {
        // NEXT GREATER ELEMENT APPROCH 
        Stack<Pair>st=new Stack<>();
        int []ans=new int[temperatures.length];
        for(int i=temperatures.length-1;i>=0;i--){
            while(st.size()>0 && st.peek().val<=temperatures[i]){
                st.pop();
            }
          
            if(st.size()>0){
                ans[i]=st.peek().idx-i;
            }
            st.push(new Pair(i,temperatures[i]));
        }
        return ans;
    }
}
