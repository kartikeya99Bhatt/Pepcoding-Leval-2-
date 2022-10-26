 public static int solve(Node root)
    {
        if(root==null)
        {
          return (Integer.MIN_VALUE);    
        }
        else if(root.left==null && root.right==null)
        {
            return(root.data);
        }
        
        int mlt=solve(root.left);
        int mrt=solve(root.right);
        int val=Math.max(root.data,Math.max(mlt,mrt)+root.data);
        ans=Math.max(ans,val);
        return val;
    }
