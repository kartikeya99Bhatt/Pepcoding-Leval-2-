/* 
IN BOTH THE APPROCH THE TIME AND SPACE COMPLEXITY WILL REMAIN SAME 
TIME COMPLEXITY=O(n)
SPACE COMPLEXITY=O(h)
*/


                                                      // ITERATIVE

class Solution
{ 
    //Function to convert binary tree into circular doubly linked list.
    public void addAllLeftNode(Node node,Stack<Node>st)
    {
        while(node!=null)
        {
            st.add(node);
            node=node.left;
        }
    }
    Node bTreeToClist(Node root)
    {
        //your code here
        Stack<Node>st=new Stack<>();
        addAllLeftNode(root,st);
        Node dummy=new Node(-1);
        Node pre=dummy;
       
        while(st.size()>0)
        {
            Node curr=st.pop();
            pre.right=curr;
            curr.left=pre;
            pre=curr;
            addAllLeftNode(curr.right,st);
        }
        
        Node head=dummy.right;
        head.left=dummy.right=null;
        head.left=pre;
        pre.right=head;
       
        return head;
    }
    
}

                                                              //  RECURSIVE  


class Solution
{ 
    //Function to convert binary tree into circular doubly linked list.
    Node bTreeToClist(Node root)
    {
        if(root==null)
        {
            return null;
        }
        //your code here
        Node left=bTreeToClist(root.left);
        Node right=bTreeToClist(root.right);
       // System.out.println(left+"   "+right);
        root.left=root.right=root;
        Node s1=concatinate(left,root);
        Node s2=concatinate(s1,right);
        
        return s2;
    }
    public static Node concatinate(Node n1,Node n2)
    {
        if(n1==null)
        {
            return n2;
        }
        else if(n2==null)
        {
            return n1;
        }
       Node t1=n1.left;
       Node t2=n2.left;
       
       t1.right=n2;
       n2.left=t1;
       
       n1.left=t2;
       t2.right=n1;
       
        return n1;
    }
    
}
    
