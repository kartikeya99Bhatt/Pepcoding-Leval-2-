class Solution {
    int max=0;
    public int longestUnivaluePath(TreeNode root) {
        max=0;
        solve(root,-10000);
        return max;
    }
    public int solve(TreeNode root,int par)
    {
        if(root==null)
        {
            return 0;
        }
        int lt=solve(root.left,root.val);
        int rt=solve(root.right,root.val);
        
        max=Math.max(lt+rt,max);
        
        return ((par==root.val)?Math.max(lt,rt)+1:0);
    }
}
