  int i=0;
    public TreeNode recoverFromPreorder(String traversal) {
            i=0;
            TreeNode root=solve(traversal,0);
            return root;
    }
    public TreeNode solve(String s,int depth)
    {
         
           int d_s=i;int d_e=i;
           // count the number of dash 
            while(i<s.length() && s.charAt(i)=='-')
            {
                i++;
            }
            d_e=i;
           
        
            int n_s=i;int n_e=i;
            // coutn number of digit in a number
            while(i<s.length() && s.charAt(i)!='-')
            {
                i++;
            }
            n_e=i;
            if(d_e-d_s!=depth)
            {
                i=d_s;
                return null;
            }
           
            String str=s.substring(n_s,n_e);
            TreeNode temp=new TreeNode();
            temp.val=Integer.parseInt(str);
            temp.left=solve(s,depth+1);
            temp.right=solve(s,depth+1);
            return temp;
    }
}
