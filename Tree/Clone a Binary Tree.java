class Solution{
    public Tree cloneTree(Tree tree){
       // add code here.
       tree=setDublicate(tree);
       setRandom(tree);
       return(breakTree(tree));
     }
     public Tree setDublicate(Tree tree)
     {
         if(tree==null)
         {
             return null;
         }
         Tree lt=setDublicate(tree.left);
         Tree rt=setDublicate(tree.right);
         Tree temp=new Tree(tree.data);
         temp.left=lt;
         tree.left=temp;
         tree.right=rt;
         return tree;
     }
     public void setRandom(Tree tree)
     {
         if(tree.random!=null)
         tree.left.random=tree.random.left;
         if(tree.left.left!=null)
         setRandom(tree.left.left);
         if(tree.right!=null)
         setRandom(tree.right);
     }
     public Tree breakTree(Tree tree)
     {
         if(tree==null)
         {
             return null;
         }
         Tree lt=breakTree(tree.left.left);
         Tree rt=breakTree(tree.right);
         Tree root=tree.left;
         tree.left=tree.left.left;// connection break
         root.left=lt;
         root.right=rt;
         return root;
     }
}
