class GfG
{
    //Function to return a tree created from postorder and inoreder traversals.
    Node buildTree(int in[], int post[], int n) {
        // Your code here
        HashMap<Integer,Integer>map=new HashMap<>();
        for(int i=0;i<n;i++){
            map.put(in[i],i);
        }
        Node root=solve(0,n-1,0,n-1,post,map);
        return root;
    }
    public  Node solve(int i_lo,int i_hi,int p_lo,int p_hi,int []post,HashMap<Integer,Integer> map)
    {
        if(i_hi<i_lo || p_hi<p_lo)
        {
            return null;
        }
        Node temp=new Node(0);
        temp.data=post[p_hi];
        int idx=map.get(temp.data);
        int diff=idx-i_lo;
        temp.left=solve(i_lo,idx-1,p_lo,p_lo+diff-1,post,map);
        temp.right=solve(idx+1,i_hi,p_lo+diff,p_hi-1,post,map);
        return temp;
    }
}
