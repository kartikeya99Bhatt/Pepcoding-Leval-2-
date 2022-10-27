class Solution
{
    //Function to return maximum path sum from any node in a tree.
    static int ans=Integer.MIN_VALUE;
    int findMaxSum(Node node)
    {
        //your code goes here
         ans=Integer.MIN_VALUE;
        solve(node);
        return ans;
    }
    public static int solve(Node node)
    {
        if(node==null)
        {
            return 0;
        }
        int lmx=solve(node.left);
        int rmx=solve(node.right);
        
        int ldt=Math.max(0,lmx);
        int rdt=Math.max(0,rmx);
        
        ans=Math.max(ans,ldt+rdt+node.data);
        return(Math.max(ldt,rdt)+node.data);
    }
}
