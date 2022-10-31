public static ArrayList<Integer> exactlyOneChild(TreeNode root) {
    ArrayList<Integer> ans = new ArrayList<>();
    solve(root,ans);
    return ans;
  }
  public static void solve(TreeNode root,ArrayList<Integer>ans)
  {
      if(root==null)
      {
          return ;
      }
      else if( (root.left==null && root.right!=null) || (root.left!=null && root.right==null) )
      {
         ans.add(root.val); 
      }
      solve(root.left,ans);
      solve(root.right,ans);
  }
