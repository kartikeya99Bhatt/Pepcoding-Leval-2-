class Solution {
    public class Pair
    {
        TreeNode head;
        TreeNode tail;
        Pair(){}
        Pair(TreeNode head,TreeNode tail){
            this.head=head;
            this.tail=tail;
        }
    }
    public void flatten(TreeNode root) {
        if(root==null)
        {
            return ;
        }
        solve( root);
    }
   /*          T(n)=O(n^2)
    public TreeNode solve(TreeNode root){
        if(root==null)
        {
            return null;
        }
        
        TreeNode left=solve(root.left);
        TreeNode right=solve(root.right);
        if(left!=null)
        {
            TreeNode sec=left;
            while(sec.right!=null)
            {
                sec=sec.right;
            }
            sec.right=right;
             root.right=left;
        }
        
        
        root.left=null;
        return root;
    }
    */
    public Pair solve(TreeNode node)
    {
        if(node.left!=null && node.right!=null)
        {
            Pair left=solve(node.left);
            Pair right=solve(node.right);
            
            Pair mp=new Pair();
            left.tail.right=right.head;
            node.right=left.head;
            node.left=null;
            mp.head=node;
            mp.tail=right.tail;
            return mp;
        }
        else if(node.left!=null)
        {
            Pair left=solve(node.left);
            node.right=left.head;
            node.left=null;
            Pair mp=new Pair(node,left.tail);
            return mp;
        }
        else if(node.right!=null)
        {
            Pair right=solve(node.right);
            node.right=right.head;
            Pair mp=new Pair(node,right.tail);
            return mp;
        }
        else //if(node.right==null && node.left==null)
        {
           Pair mp=new Pair(node,node);
            return mp;
        }
    }
}
