/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {
    class Pair{
        TreeNode node;
        int state;
        Pair(TreeNode node,int state)
        {
            this.node=node;
            this.state=state;
        }
    }

    // Encodes a tree to a single string.
    StringBuilder str=new StringBuilder("");
    public String serialize(TreeNode root) {
       
        solve(root);
        return(str.toString());
    }
   public void solve(TreeNode root){
       if(root==null)
        {
            str.append("null ");
          
           return ;
        }
        str.append(root.val+" ");
        serialize(root.left);
        serialize(root.right);
   }
    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data.equals("null "))
        {
            return null;
        }
       String []arr=data.split(" ");
       
        TreeNode root=new TreeNode(Integer.parseInt(arr[0]));
       Stack<Pair>st=new Stack<>();
       st.push(new Pair(root,0));
        
        
         int i=0;
        while(st.size()>0)
        {
             
            Pair temp=st.peek();
            
             if(temp.state==0)
            {
                i++;
                temp.state++;
                 if(arr[i].equals("null")==false){
                     TreeNode leftNode=new TreeNode(Integer.parseInt(arr[i]));
                    st.push(new Pair(leftNode,0));
                    
                    
                    temp.node.left=leftNode;
                 }
                
            }
            else if(temp.state==1)
            {
                 i++;
                 temp.state++;
                 if(arr[i].equals("null")==false){
                     TreeNode rightNode=new TreeNode(Integer.parseInt(arr[i]));
                     st.push(new Pair(rightNode,0));
                     
                     temp.node.right=rightNode;
                 }
            }
            else if(temp.state==2)
            {
               
                st.pop();
                
            }
           
        }
        
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));
