class Solution {
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
         List<List<Integer>>ans=new ArrayList<>();
        if(root==null)
        {
            return ans;
        }
        List<Integer>list=new ArrayList<>();
        solve(root,targetSum,ans,list);
        return ans;
    }
    public void solve(TreeNode root,int targetSum,List<List<Integer>>ans,List<Integer>list)
    {
        if(root.left==null && root.right==null)
        {
            if(targetSum-root.val==0)
            {
                  list.add(root.val);
                  ans.add(new ArrayList<>(list));
                  list.remove(list.size()-1);
                
            }
            return ;
        }
        if(root.left!=null)
        {
            list.add(root.val);
            solve(root.left,targetSum-root.val,ans,list);
            list.remove(list.size()-1);
        }
        if(root.right!=null)
        { 
            list.add(root.val);
             solve(root.right,targetSum-root.val,ans,list);
             list.remove(list.size()-1);
        }
    }
}
