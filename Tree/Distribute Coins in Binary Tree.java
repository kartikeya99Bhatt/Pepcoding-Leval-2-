class Solution {
    class Pair
    {
        int nodeCount;
        int coinCount;
        Pair(int nodeCount,int coinCount)
        {
            this.nodeCount=nodeCount;
            this.coinCount=coinCount;
        }
    }
    static int count =0;
    public int distributeCoins(TreeNode root) {
        count =0;
        solve(root);
        return count ;
    }
    public Pair solve(TreeNode node)
    {
        if(node==null)
        {
            Pair mp=new Pair(0,0);
            return mp;
        }
        Pair left=solve(node.left);
        Pair right=solve(node.right);
        
        count+=Math.abs(left.nodeCount-left.coinCount)+Math.abs(right.nodeCount-right.coinCount);
        Pair mp=new Pair( (left.nodeCount+right.nodeCount+1) , (left.coinCount+right.coinCount+node.val) );
        return mp;
    }
}
