class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        HashMap<Integer,Integer>map=new HashMap<>();
        for(int i=0;i<inorder.length;i++)
        {
            map.put(inorder[i],i);
        }
        TreeNode root=construct(0,preorder.length-1,0,inorder.length-1,preorder,map);
        return root;
    }
    public TreeNode construct(int pre_lo,int pre_hi,int in_lo,int in_hi,int []preorder,HashMap<Integer,Integer>map)
    {
        // base case
        if(pre_lo>pre_hi || in_lo>in_hi)
        {
          return null;    
        }
        
        TreeNode node=new TreeNode();
        
        node.val=preorder[pre_lo];
        int idx=map.get(node.val);
        int diff=idx-in_lo;
        
        node.left=construct(pre_lo+1,pre_lo+diff  ,  in_lo,idx-1,preorder,map);
        node.right=construct(pre_lo+diff+1,pre_hi  ,  idx+1,in_hi,preorder,map);
        
        return node;
    }
    
}
