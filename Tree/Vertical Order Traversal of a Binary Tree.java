class Solution {
    public class Pair implements Comparable <Pair>
    {
        TreeNode node;
        int hori;
        int ver;
        Pair(TreeNode node,int hori,int ver)
        {
            this.node=node;
            this.hori=hori;
            this.ver=ver;
        }
        public int compareTo(Pair o)
        {
            if(this.ver==o.ver)
            {
                return(this.node.val-o.node.val);
            }
            else
            {
                return (this.ver-o.ver);
            }
        }
        
    }
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>>ans=new  ArrayList<>();
        HashMap<Integer,PriorityQueue<Pair>>map=new HashMap<>();
        Queue<Pair>q=new ArrayDeque<>();
        q.add(new Pair(root,0,1));
        int max=0;
        int min=0;
        while(q.size()>0)
        {
            Pair temp=q.remove();
            max=temp.idx>max?temp.idx:max;
            min=temp.idx<min?temp.idx:min;
            if(map.containsKey(temp.hori))
            {
                map.get(temp.hori).add(temp);;
            }
            else
            {
                map.put(temp.hori,new PriorityQueue<>()) ;
                map.get(temp.hori).add(temp);
            }
            if(temp.node.left!=null)
            {
                q.add(new Pair(temp.node.left,temp.hori-1,temp.ver+1));
            }
            if(temp.node.right!=null)
            {
                q.add(new Pair(temp.node.right,temp.hori+1,temp.ver+1));
            }
        }
        
        for(int i=min;i<=max;i++)
        {
            if(map.containsKey(i))
            {
                    ArrayList<Integer>temp=new ArrayList<>();
                   while(map.get(i).size()>0)
                   {
                       temp.add(map.get(i).remove().node.val);
                   }
                  ans.add(temp);
            }
            
        }
        return ans ;
    }
}
