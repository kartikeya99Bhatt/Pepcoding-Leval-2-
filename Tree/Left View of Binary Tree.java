class Tree
{
    //Function to return list containing elements of left view of binary tree.
    ArrayList<Integer> leftView(Node root)
    {
      // Your code here
      ArrayList<Integer>ans=new ArrayList<>();
      if(root==null)
      {
          return ans;
      }
      Queue<Node>pq=new ArrayDeque<>();
      Queue<Node>cq=new ArrayDeque<>();
      pq.add(root);
      int count=0;
      
      while(pq.size()>0)
      {
          Node temp=pq.remove();
          if(count==0)
          {
              ans.add(temp.data);
              count=1;
          }
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
              count=0;
              pq=cq;
              cq=new ArrayDeque<>();
          }
      }
      return ans;
    }
}
