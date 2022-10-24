class Solution
{
    static class Pair
    {
        Node node;
        int idx;
        Pair(Node node,int idx)
        {
            this.node=node;
            this.idx=idx;
        }
    }
    //Function to return a list of nodes visible from the top view 
    //from left to right in Binary Tree.
    static ArrayList<Integer> topView(Node root)
    {
        // add your code
        HashMap<Integer,Integer>map=new HashMap<>();
        Queue<Pair>pq=new ArrayDeque<>();
        int max=0;
        int min=0;
        pq.add(new Pair(root,0));
        while(pq.size()>0)
        {
            Pair temp=pq.remove();
            min=(temp.idx<min)?temp.idx:min;
            max=(temp.idx>max)?temp.idx:max;
            
            if(map.containsKey(temp.idx)==false)
            map.put(temp.idx,temp.node.data);
            
            if(temp.node.left!=null)
            {
                pq.add(new Pair(temp.node.left,temp.idx-1));
            }
            if(temp.node.right!=null)
            {
                pq.add(new Pair(temp.node.right,temp.idx+1));
            }
           
        }
        
    
        ArrayList<Integer>ans=new ArrayList<>();
        for(int i=min;i<=max;i++)
        {
            ans.add(map.get(i));
        }
        return ans;
    }
}
