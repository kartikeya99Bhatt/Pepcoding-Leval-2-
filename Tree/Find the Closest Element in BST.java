class Solution
{
    
    static int ans=0;
    static int diff=Integer.MAX_VALUE;
    static int minDiff(Node  root, int k) 
    { 
        // Write your code here
        ans=0;diff=Integer.MAX_VALUE;
        solve(root,k);
        return diff;
    } 
    public static void solve(Node root,int k)
    {
        if(root==null)
        {
            return ;
        }
        int newdiff=Math.abs(k-root.data);
       // System.out.println(newdiff);
        if(newdiff<diff)
        {
            diff=newdiff;
            ans=root.data;
        }
       if(root.data<k)
       {
           solve(root.right,k);
       }
       else if(root.data>k)
       {
           solve(root.left,k);
       }
    }
}
