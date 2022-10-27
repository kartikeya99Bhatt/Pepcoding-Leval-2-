 class Solution {
     static long ans=0;
     int MOD=1000000000+7;
    public long imgMultiply(Node root)
    {
        // code here
        ans=(root.data*root.data)%MOD;
        solve(root.left,root.right);
        return ans;
    }
    public void solve(Node lt,Node rt)
    {
        if(lt==null || rt==null)
        {
            return ;
        }
        ans=(ans%MOD+(lt.data*rt.data)%MOD)%MOD;
        solve(lt.left,rt.right);
        solve(lt.right,rt.left);
    }
}
