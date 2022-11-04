class Solution {
    public List<TreeNode> generateTrees(int n) {
        return (solve(1,n));
    }
    public List<TreeNode> solve(int st,int ed)
    {
        
       if(ed<st)
        {
            List<TreeNode>base=new ArrayList<>();
            base.add(null);
            return base;
        }
         ArrayList<TreeNode>ans=new ArrayList<>();
        for(int i=st;i<=ed;i++)
        {
            List<TreeNode>left=solve(st,i-1);
            List<TreeNode>right=solve(i+1,ed);
            
            for(TreeNode l:left)
            {
                for(TreeNode r:right)
                {
                    TreeNode root=new TreeNode(i);
                    root.left=l;
                    root.right=r;
                    ans.add(root);
                }
            }
        }
        return ans;
    }
    
}
