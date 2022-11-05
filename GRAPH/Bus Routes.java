class Solution {
    class Pair
    {
        int bus;
        int csf;
        Pair(int bus,int csf){
            this.bus=bus;
            this.csf=csf;
        }
    }
    public int numBusesToDestination(int[][] routes, int source, int target) {
        if(source==target)
        {
            return 0;
        }
        HashMap<Integer,HashSet<Integer>>map=new HashMap<>();
        for(int i=0;i<routes.length;i++)
        {
            for(int val:routes[i])
            {
                if(map.containsKey(val)==false)
                {
                   map.put(val,new HashSet<>());
                    map.get(val).add(i);
                }
                else
                {
                    map.get(val).add(i); 
                }
            }
        }
        boolean []visited=new boolean[routes.length];
        Queue<Pair>pq=new ArrayDeque<>();
        for(int value:map.get(source))
        {
            pq.add(new Pair(value,1));
        }
        while(pq.size()>0)
        {
            // remove
            Pair temp=pq.remove();
            
            // mark*
            if(visited[temp.bus]==true)
            {
                continue;
            }
            visited[temp.bus]=true;
            //work 
            for(int value:routes[temp.bus])
            {
                if(value==target)
                {
                    return temp.csf;
                }
            }
            
            //addchildren
            for(int val:routes[temp.bus])
            {
                for(int value:map.get(val))
                {
                   if(visited[value]==false)
                   {
                       pq.add(new Pair(value,temp.csf+1));
                   }
                }
            }
        }
        
        return -1;
    }
}
