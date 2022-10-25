 public static void iterativePrePostInTraversal(Node node) {
    // write your code here
    Stack<pair>st=new Stack<>();
    st.add(new pair(node,0));
    StringBuilder preorder=new StringBuilder("");
    StringBuilder inorder=new StringBuilder("");
    StringBuilder postorder=new StringBuilder("");
    
    while(st.size()>0)
    {
        pair temp=st.peek();
        if(temp.idx==0)
        {
            preorder.append(temp.node.data+" ");
            temp.idx++;
            if(temp.node.left!=null)
            st.add(new pair(temp.node.left,0));
        }
       else if(temp.idx==1)
       {
            inorder.append(temp.node.data+" ");
            temp.idx++;
            if(temp.node.right!=null)
            st.add(new pair(temp.node.right,0));
       }
       else if(temp.idx==2)
       {
           postorder.append(temp.node.data+" ");
           st.pop();
       }
    }
    
    System.out.println(preorder+"\n"+inorder+"\n"+postorder);
    
  }
