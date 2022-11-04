class Solution {
    public List<Integer> pathInZigZagTree(int label) {
        int ctval=0;
        int llv=1;
        while(ctval<label)
        {
            ctval+=llv;
            llv*=2;    
        }
        llv/=2;
        
        List<Integer>ans=new ArrayList<>();
        while(llv>0)
        {
            ans.add(label);
            int comp=3*llv-label-1;
            label=comp/2;
            llv/=2;
        }
        
        
            Collections.reverse(ans);
        return ans;
    }
}
