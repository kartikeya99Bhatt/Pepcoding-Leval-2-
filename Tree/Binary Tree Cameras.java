class Solution {
    static int  count =0;
    public int minCameraCover(TreeNode root) {
       count =0;
       char ch= solve(root);
        if(ch=='N')
        {
            count++;
        }
        return count ;
    }
    public char solve(TreeNode root)
    {
        if(root==null)
        {
            return 'M';
        }
       
        char lch=solve(root.left);
        char rch=solve(root.right);
        if(lch=='N' || rch=='N')
        {
             count++;
            return 'C';
        }
        else if(lch=='C'||rch=='C')
        {
            return 'M';
        }
        else
        {
            return 'N';
        }
    }
}
