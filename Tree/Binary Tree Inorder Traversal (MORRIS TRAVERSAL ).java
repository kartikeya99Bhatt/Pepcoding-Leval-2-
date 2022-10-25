class Solution {
    public TreeNode precedence(TreeNode node , TreeNode curr)
    {
        while(node.right!=null && node.right!=curr)
        {
            node=node.right;
        }
        return node;
    }
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer>ans=new ArrayList<>();
        
        TreeNode curr=root;
        while(curr!=null)
        {
            if(curr.left==null)
            {
                ans.add(curr.val);
                curr=curr.right;
            }
            else if(curr.left!=null)
            {
                TreeNode pre=precedence(curr.left,curr) ;
                if(pre.right!=curr)
                {
                    pre.right=curr;
                    curr=curr.left;
                }
                else if(pre.right==curr)
                {
                    pre.right=null;
                    ans.add(curr.val);
                    curr=curr.right;
                }
            }
        }
            
        return ans;
    }
}
