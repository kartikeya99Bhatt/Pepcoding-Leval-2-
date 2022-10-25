class Solution {
    int xKiLeft=0;
    int xKiRight=0;
    public int size(TreeNode root,int x)
    {
        if(root==null){return 0;}
        int ls=size(root.left,x);
        int rs=size(root.right,x);
        if(root.val==x)
        {
            xKiLeft=ls;
            xKiRight=rs;
        }
        return (ls+rs+1);
    }
    public boolean btreeGameWinningMove(TreeNode root, int n, int x) {   
        int ts=size(root,x);
        int otr=ts-(xKiLeft+xKiRight+1);
        int max=Math.max(otr,Math.max(xKiLeft,xKiRight));
        return(max>ts-max);
    }
}
