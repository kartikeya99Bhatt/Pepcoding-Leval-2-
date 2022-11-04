class Solution {
    public List<TreeNode> allPossibleFBT(int n) {
       
        return solve(n);
    }
    public List<TreeNode> solve(int n)
    {
        if(n==1)
        {
            ArrayList<TreeNode>base=new ArrayList<>();
            base.add(new TreeNode(0));
            return base;
        }
        ArrayList<TreeNode>ans=new ArrayList<>();
        for(int i=1;i<n;i+=2)
        {
            
                List<TreeNode>left=solve(i);
                List<TreeNode>right=solve(n-i-1);
                
                for(TreeNode lf:left)
                {
                    for(TreeNode rt:right)
                    {
                        TreeNode newRoot=new TreeNode(0);
                        newRoot.left=lf;
                        newRoot.right=rt;
                        ans.add(newRoot);
                    }
                }
        }
        return ans;
    }
}
