class Solution {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
    
   List<List<Integer>>ans=new ArrayList<>();    
    if(root==null)
      {
          return (ans);
      }
        Stack<ArrayList>st=new Stack<>();
        Queue<TreeNode>pq=new ArrayDeque<>();
        Queue<TreeNode>cq=new ArrayDeque<>();
        pq.add(root);
        List<Integer>list=new ArrayList<>();
       
     
        
        while(pq.size()>0)
        {
            TreeNode temp=pq.remove();
             list.add(temp.val);
            if(temp.left!=null)
            {
                cq.add(temp.left);
              
            }
            if(temp.right!=null)
            {
                cq.add(temp.right);
              
            }
            if(pq.size()==0)
            {
                pq=cq;
                cq=new ArrayDeque<>();
                st.push(new ArrayList(list));
                list=new ArrayList<>();   
            }
        }
        while(st.size()>0)
        {
            ans.add(st.pop());
        }
        return ans;
    }
}
