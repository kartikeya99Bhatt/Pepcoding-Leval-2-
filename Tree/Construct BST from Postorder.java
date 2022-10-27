class GFG
{
    static int idx=0; 
    public static Node constructTree(int post[],int n)
    {
        //Add your code here.
        idx=n-1;
        Node root=solve(post,Integer.MIN_VALUE,Integer.MAX_VALUE);
        return root;
    }
    public static Node solve(int []post,int min,int max)
    {
        if(idx>-1 && post[idx]>min && post[idx]<max)
        {
            Node temp=new Node(post[idx--]);
            temp.right=solve(post,temp.data,max);
            temp.left=solve(post,min,temp.data);
            return temp;
        }
        else
        {
            return null;
        }
    }
}
