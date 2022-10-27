class Solution
{
    static int max=Integer.MIN_VALUE;
    int maxPathSum(Node node)
    { 
        // code here 
        max=Integer.MIN_VALUE;
        if(node.right!=null && node.left!=null)
        {
            solve(node);
            return max;
        }
        else if(node.left!=null)
        {
            int value=solve(node);
            max=Math.max(value,max);
            return max;
        }
        else if(node.right!=null)
        {
            int value=solve(node);
            max=Math.max(value,max);
            return max;
        }
        else
        {
            // node is only there in a tree
            return node.data;
        }
       
    } 
    public  int solve(Node node)
    {
         if(node.left!=null && node.right!=null)
        {
            int left=solve(node.left);
            int right=solve(node.right);
            max=Math.max(left+right+node.data,max);
            return (Math.max(left,right)+node.data);
        }
        else if(node.left!=null)
        {
            int left=solve(node.left);
            return(left+node.data);
        }
        else if(node.right!=null)
        {
            int right=solve(node.right);
            return (right+node.data);
        }
        else
        {
            // node is leaf 
            return node.data;
        }
    }
}
