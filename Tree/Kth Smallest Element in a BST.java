class Solution {
    public TreeNode precedence(TreeNode node,TreeNode curr)
    {
        while(node.right!=null && node.right!=curr)
        {
            node=node.right;
        }
        return node;
    }
    public int kthSmallest(TreeNode root, int k) {
        
        TreeNode curr=root;
        int count=0;
        int ans=0;
        while(curr!=null)
        {
            if(curr.left==null)
            {
                // print
                count++;
                if(count==k)
                {
                    ans=curr.val;
                    break;
                }
                curr=curr.right;
            }
            else if(curr.left!=null)
            {
                 TreeNode pre=precedence(curr.left,curr);
                if(pre.right!=curr) // first time visit
               {
                  pre.right=curr;
                  curr=curr.left;
                }
               else if(pre.right==curr) // secound time visit 
                {
                    pre.right=null;
                    //print
                   count++;
                    if(count==k)
                {
                    ans=curr.val;
                    break;
                }
                   curr=curr.right;
                }
            }
        }
        return ans;
        
    }
}
