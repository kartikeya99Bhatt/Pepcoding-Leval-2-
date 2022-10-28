class Solution {
    public Node connect(Node root) {
        
        solve(root);
        return root;
    }
    public void solve(Node root)
    {
        Node curr=root;
        Node head=null ; Node tail=null;
   
     while(curr!=null)
     {
        while(curr!=null)
        {
            if(curr.left!=null)
            {
                if(head==null)
                {
                    head=tail=curr.left;
                }
                else
                {
                    tail.next=curr.left;
                    tail=tail.next;
                }
            }
            if(curr.right!=null)
            {
                if(head==null)
                {
                    head=tail=curr.right;
                }
                else
                {
                  tail.next=curr.right;
                  tail=tail.next;
                }
            }
            
            curr=curr.next;
        }
         curr=head;
         head=tail=null;
       
     }  
    }
}
