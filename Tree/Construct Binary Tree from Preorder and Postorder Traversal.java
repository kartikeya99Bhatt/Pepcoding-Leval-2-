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
    public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
        HashMap<Integer,Integer>map=new HashMap<>();
        for(int i=0;i<postorder.length;i++){
            map.put(postorder[i],i);
        }
        
        return solve(0,preorder.length-1,0,postorder.length-1,preorder,map);
    }
    public TreeNode solve(int prelo,int prehi,int postlo,int posthi,int []preorder,HashMap<Integer,Integer>map)
    {
       System.out.println(prelo+"-"+prehi +"/"+postlo+" "+posthi);
        if(prelo>prehi || postlo>posthi)
        {
            return null;
        }
        TreeNode temp=new TreeNode(preorder[prelo]);
        if(prelo+1<=prehi)
        {
            int idx=map.get(preorder[prelo+1]);
            int count=idx-postlo;
            temp.left=solve(prelo+1,prelo+1+count,postlo,idx,preorder,map);
            temp.right=solve(prelo+1+count+1,prehi,idx+1,posthi-1,preorder,map);
            return temp;    
        }
       return temp;
      
    }
    
}
