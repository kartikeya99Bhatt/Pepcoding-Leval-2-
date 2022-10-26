class Solution {
    public int countNodes(TreeNode root) {
        
        return(size(root));
    }
    public int size(TreeNode root)
    {
        if(root==null)
        {
            return 0;
        }
        int lht=0;
        TreeNode left=root.left;
        while(left!=null)
        {
            left=left.left;
            lht++;
        }
        
        int rht=0;
        TreeNode right=root.right;
        while(right!=null)
        {
            right=right.right;
            rht++;
        }
        if(lht==rht)
        {
            return ((int)Math.pow(2,lht+1)-1);
        }
        else
        {
            int lsz=size(root.left);
            int rsz=size(root.right);
            return (lsz+rsz+1);
        }
    }
}
