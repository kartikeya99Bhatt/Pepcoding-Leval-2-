class Solution{
    //Function to return list containing elements of right view of binary tree.
    ArrayList<Integer> rightView(Node node)
    {
        //add code here.
        ArrayList<Integer>ans=new ArrayList<>();
        if(node==null)
        {
            return ans;
        }
        Queue<Node>pq=new ArrayDeque<>();
        Queue<Node>cq=new ArrayDeque<>();
        pq.add(node);
        
        while(pq.size()>0)
        {
            Node temp=pq.remove();
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
                ans.add(temp.data);
            }
            
        }
        
        return ans;
        
    }
}

