class GfG
{
    Node buildTree(int inord[], int level[])
    {
        //your code here
        HashMap<Integer,Integer>map=new HashMap<>();
        for(int i=0;i<level.length;i++){
            map.put(level[i],i);
        }
        Node root=solve(0,inord.length-1,inord,map);
        return root;
    }
    public static Node solve(int inlo,int inhi,int []inorder,HashMap<Integer,Integer>map)
    {
        if(inlo>inhi)
        {
            return null;
        }
        int idx=inhi;
        for(int i=inlo;i<=inhi;i++)
        {
            if(map.get(inorder[i])<map.get(inorder[idx]))
            {
                idx=i;
            }
           
        }
        Node temp=new Node(inorder[idx]);
        temp.left=solve(inlo,idx-1,inorder,map);
        temp.right=solve(idx+1,inhi,inorder,map);
        return temp;
    }
   
}

