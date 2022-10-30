
  public static ArrayList<Integer> morrisPreTraversal(TreeNode root) {
      ArrayList<Integer>ans=new ArrayList<>();
     
     TreeNode curr=root;
     while(curr!=null)
     {
         if(curr.left==null)
         {
            // print 
            ans.add(curr.val);
            curr=curr.right;
         }
         else if(curr.left!=null)
         {
             TreeNode pre=precedence(curr.left,curr);
             if(pre.right!=curr)
             {
                 ans.add(curr.val);
                 pre.right=curr;
                 curr=curr.left;
             }
             else if(pre.right==curr)
             {
                 pre.right=null;
                 // print
                 curr=curr.right;
                 
             }
         }
         
     }
     
    return ans;
  }
