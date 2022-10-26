class Solution
{
    public static Node buildTree(int inorder[], int preorder[], int n)
    {
        // code here 
        HashMap<Integer,Integer>map=new HashMap<>();
        for(int i=0;i<n;i++){
            map.put(inorder[i],i);
        }
        Node root=solve(0,inorder.length-1,0,preorder.length-1,preorder,map);
        return root;
    }
    
    public static Node solve(int i_lo,int i_hi,int p_lo,int p_hi,int []preorder,HashMap<Integer,Integer> map) 
    {
        if(i_hi<i_lo || p_hi<p_lo)
        {
            return null;
        }
        Node temp=new Node(0);
        
        temp.data=preorder[p_lo];
        int idx=map.get(temp.data);
        int diff=idx-i_lo;
        temp.left=solve(i_lo,idx-1,p_lo+1,p_lo+diff,preorder,map);
        temp.right=solve(idx+1,i_hi,p_lo+diff+1,p_hi,preorder,map);
        return temp;
    }
}
