SOLUTION 1: -
  
class Solution {
    /*you are required to complete this function */
    boolean hasPathSum(Node root, int S) {
        // Your code here
        return solve(root,S,0);
    }
    public boolean solve(Node root,int target,int currSum)
    {
        if(root.left==null && root.right==null)
        {
            if(currSum+root.data==target)
            {
                return true;
            }
        }
        if(root.left!=null)
        {
            boolean res=solve(root.left,target,currSum+root.data);
           if(res==true)
           {
               return true;
           }
        }
       
        if(root.right!=null)
        {
            boolean res=solve(root.right,target,currSum+root.data);
            if(res==true)
            {
                return true;
            }
        }
        return false;
    }
}

SOLUTION 2: -

class Solution {
    /*you are required to complete this function */
    boolean hasPathSum(Node root, int S) {
        // Your code here
        return solve(root,S);
    }
    public boolean solve(Node root,int target)
    {
        if(root.left==null && root.right==null)
        {
            if(target-root.data==0)
            {
                return true;
            }
        }
        if(root.left!=null)
        {
            boolean res=solve(root.left,target-root.data);
            if(res==true)
            {
                return true;
            }
        }
        if(root.right!=null)
        {
           boolean res=solve(root.right,target-root.data);
           if(res==true)
           {
               return true;
           }
        }
        return false;
    }
}
