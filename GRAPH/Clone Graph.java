class Solution {
    public Node cloneGraph(Node node) {
        if(node==null)
        {
            return null;
        }
        HashMap<Integer,Node>map=new HashMap<>();
        return(helper(node,map));
    }
    public Node helper(Node node,HashMap<Integer,Node>map)
    {
        Node newNode=new Node(node.val);
        map.put(node.val,newNode);
        for(Node nbr:node.neighbors)
        {
            if(map.containsKey(nbr.val)==false)
            {
                Node res=helper(nbr,map);
                newNode.neighbors.add(res);
            }
            else
            {
                newNode.neighbors.add(map.get(nbr.val));
            }
        }
        return newNode;
    }
}
