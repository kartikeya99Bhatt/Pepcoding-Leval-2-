class Solution {
    public TreeNode addOneRow(TreeNode root, int val, int depth) {
        
        solve(root,val,depth,2);
        return root;
    }
    public void solve(TreeNode root,int val,int depth,int currDepth)
    {
        if(root==null)
        {
            return ;
        }
        else if(depth==currDepth)
        {
            TreeNode lt=new TreeNode(val,root.left,null);
            TreeNode rt=new TreeNode(val,null,root.right);
            root.left=lt;
            root.right=rt;
            return ;
        }
        solve(root.left,val,depth,currDepth+1);
        solve(root.right,val,depth,currDepth+1);
    }
    
}
