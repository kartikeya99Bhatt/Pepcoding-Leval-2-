class Solution
{
   static  boolean flag1=false,flag2=false;
    //Function to return the lowest common ancestor in a Binary Tree.
	Node lca(Node root, int n1,int n2)
	{
		// Your code here
		flag1=false;flag2=false;
		Node rootf=solve(root,n1,n2);
	if(flag1==true && flag2==true)
		return rootf;
		else
		return null;
		
	}
	public static Node solve(Node root,int n1,int n2)
	{
	    if(root==null)
	    {
	        return null;
	    }
	    Node lf=solve(root.left,n1,n2);
	    Node rt=solve(root.right,n1,n2);
	    
	    if(lf!=null && rt!=null)
	    {
	        return root;
	    }
	    else if(root.data==n1)
	    {
	        flag1=true;
	        return root;
	    }
	    else if(root.data==n2)
	    {
	        flag2=true;
	        return root;
	    }
	     else if(lf==null && rt!=null)
	    {
	        return rt;
	    }
	    else if(rt==null && lf!=null)
	    {
	        return lf;
	    }
	    else
	    {
	        return null;
	    }
	    
	 
	}
}

