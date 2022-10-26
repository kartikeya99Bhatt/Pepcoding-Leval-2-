class Solution
{
    static int ans=Integer.MIN_VALUE;
    public static int maxPathSum(Node root)
    {
        //code here
        ans=Integer.MIN_VALUE;
        solve(root,0);
         return ans;
    }
    public static void solve(Node node,int sum)
    {
        if(node.left==null && node.right==null)
        {
            ans=Math.max(ans,sum+node.data);
            return;
        }
        if(node.left!=null)
        solve(node.left,sum+node.data);
        if(node.right!=null)
        solve(node.right,sum+node.data);
    }
}
