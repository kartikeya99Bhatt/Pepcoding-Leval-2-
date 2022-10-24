class Solution
{
    public void left(Node node,ArrayList<Integer>ans)
    {
        if(node.left!=null || node.right!=null)
        ans.add(node.data);
        if(node.left!=null)
        left(node.left,ans);
        else if(node.left==null && node.right!=null)
        left(node.right,ans);
    }
    public void leaves(Node node,ArrayList<Integer>ans)
    {
        if(node.left==null && node.right==null)
        ans.add(node.data);
        if(node.left!=null)
        leaves(node.left,ans);
        if(node.right!=null)
        leaves(node.right,ans);
    }
    public void right(Node node,ArrayList<Integer>ans)
    {
        if(node.right!=null)
        right(node.right,ans);
        else if(node.right==null && node.left!=null)
        right(node.left,ans);
        if(node.left!=null || node.right!=null)
        ans.add(node.data);
    }
	ArrayList <Integer> boundary(Node node)
	{
	    ArrayList<Integer>ans=new ArrayList<>();
	    ans.add(node.data);
	    if(node.left!=null)
	    left(node.left,ans);
	    
	     if(node.left!=null)
	     leaves(node.left,ans);
	     if(node.right!=null)
	     leaves(node.right,ans);
	     
	    if(node.right!=null)
	    right(node.right,ans);
	    return ans;
	}
}
