class Solution {
    class Pair
    {
        int withRobbry;
        int withoutRobbry;
        Pair(int withRobbry,int withoutRobbry)
        {
            this.withRobbry=withRobbry;
            this.withoutRobbry=withoutRobbry;
        }
    }
    public int rob(TreeNode root) {
       Pair temp=solve(root);
        return (Math.max(temp.withRobbry,temp.withoutRobbry));
    }
    public Pair solve(TreeNode root)
    {
         if(root==null)
        {
            return new Pair(0,0);
        }
        Pair left=solve(root.left);
        Pair right=solve(root.right);
        
        return new Pair(left.withoutRobbry+right.withoutRobbry+root.val , Math.max(left.withRobbry,left.withoutRobbry)+Math.max(right.withRobbry,right.withoutRobbry));
    }
}
