static int minTime=0;
    public static int minTime(Node root, int target) 
    {
        // Your code goes here
        minTime=0;
        ArrayList<Node>path=NodeToRootPath(root,target);
        Node block=null;
        for(int i=0;i<path.size();i++)
        {
            calculateTime(path.get(i),i,block);
            block=path.get(i);
        }
        return minTime;
    }
     public static void calculateTime(Node  root,int t,Node block)
    {
        if(root==null || root==block)
        {
            return;
        }
        minTime=Math.max(minTime,t);
        calculateTime(root.left,t+1,block);
        calculateTime(root.right,t+1,block);
    }
    public static ArrayList<Node> NodeToRootPath(Node root,int target){
    if(root==null)
    {
        return (new ArrayList<>());
    }
    else if(root.data==target)
    {
        ArrayList<Node>base=new ArrayList<>();
        base.add(root);
        return base;
    }
    ArrayList<Node>lt=NodeToRootPath(root.left,target);
    if(lt.size()>0)
    {
        lt.add(root);
        return lt;
    }
    ArrayList<Node>rt=NodeToRootPath(root.right,target);
    if(rt.size()>0)
    {
        rt.add(root);
        return rt;
    }
    return (new ArrayList<>()); 
}
}
