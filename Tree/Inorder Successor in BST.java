class Solution
{
    public Node precedence(Node node,Node curr)
    {
        while(node.right!=null && node.right!=curr)
        {
            node=node.right;
        }
        return node;
    }
    // returns the inorder successor of the Node x in BST (rooted at 'root')
	public Node inorderSuccessor(Node root,Node x)
     {
      //add code here.
        Node curr=root;
        boolean found=false;
        Node ans=null;
        while(curr!=null)
        {
            if(curr.left==null)
            {
                // print;
                if(found==true)
                {
                    ans=curr;
                    break;
                    
                }
                if(curr.data==x.data)
                {
                    found=true;
                }
                curr=curr.right;
            }
            else if(curr.left!=null)
            {
                Node pre=precedence(curr.left,curr);
                if(pre.right!=curr)
                {
                    pre.right=curr;
                    curr=curr.left;
                    
                }
                else if(pre.right==curr)
                {
                    //print
                    if(found==true)
                    {
                         ans=curr;
                        break;
                    }
                    if(curr.data==x.data)
                    {
                        found=true;
                    }
                    pre.right=null;
                    curr=curr.right;
                }
            }
        }
        return ans;
     }
}
