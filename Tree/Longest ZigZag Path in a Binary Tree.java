/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
     static int max=0;
    class Pair
    {
        int countForward;
        int countBackward;
        Pair(int countForward,int countBackward)
        {
            this.countForward=countForward;
            this.countBackward=countBackward;
        }
    }
    public int longestZigZag(TreeNode root) {
        max=0;
        solve(root);
        return max;
    }
    public Pair solve(TreeNode root)
    {
        if(root==null)
        {
            return (new Pair(-1,-1));
        }
        Pair left=solve(root.left);
        Pair right=solve(root.right);
        
        max=Math.max(max,Math.max(left.countBackward,right.countForward)+1);
        return (new Pair(left.countBackward+1,right.countForward+1));
    }
}
