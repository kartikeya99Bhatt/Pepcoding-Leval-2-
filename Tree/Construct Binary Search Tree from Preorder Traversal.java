    static int idx=0;
    public TreeNode bstFromPreorder(int[] preorder) {
        idx=0;
        TreeNode root=solve(preorder,Integer.MIN_VALUE,Integer.MAX_VALUE);
        return root;
    }
    public TreeNode solve(int []preorder,int min,int max)
    {
        if(idx<preorder.length &&  preorder[idx]>min && preorder[idx]<max)
        {
            TreeNode temp=new TreeNode();
            temp.val=preorder[idx++];
            temp.left=solve(preorder,min,temp.val);
            temp.right=solve(preorder,temp.val,max);
            return temp;
        }
        else
        {
            return null;
        }
    }
