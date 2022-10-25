class Solution {
    public TreeNode precedence(TreeNode node,TreeNode curr){
        while(node.right!=null && node.right!=curr)
        {
            node=node.right;
        }
        return node;
    }
    public void recoverTree(TreeNode root) {
        
        TreeNode curr=root;
        TreeNode previous=null;
        TreeNode n1=null;
        TreeNode n2=null;
        while(curr!=null)
        {
            if(curr.left==null)
            {
                // print
                if(previous!=null && previous.val>curr.val)
                {
                    if(n1==null && n2==null)
                    {
                        n1=previous;
                        n2=curr;
                    }
                    else
                    {
                        n2=curr;
                    }
                }
                
                previous=curr;
                curr=curr.right;
            }
            else if(curr.left!=null)
            {
                TreeNode pre=precedence(curr.left,curr);
                if(pre.right!=curr)
                {
                    pre.right=curr;
                    curr=curr.left;
                    
                }
                else
                {
                    //print
                    if(previous!=null && previous.val>curr.val)
                    {
                        if(n1==null && n2==null)
                        {
                            n1=previous;
                            n2=curr;
                        }
                        else
                        {
                            n2=curr;
                        }
                    }
                    previous=curr;
                    pre.right=null;
                    curr=curr.right;
                }
            }
        }
        int temp=n1.val;
        n1.val=n2.val;
        n2.val=temp;
    }
}
