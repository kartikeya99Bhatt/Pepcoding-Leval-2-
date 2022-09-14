class Solution {
    public int minRefuelStops(int target, int startFuel, int[][] stations) {
        
        PriorityQueue<Integer>pq=new PriorityQueue<>(Collections.reverseOrder());
        int range=startFuel;
        int count=0;int i=0;
        while(range<target)
        {
            while(i<stations.length && stations[i][0]<=range)
            {
                pq.add(stations[i][1]);
                i++;
            }
            if(pq.size()>0)
            {
             range+=pq.remove();
             count++;
            }
            else
            {
                break;
            }
       }
        return ( (range>=target)?count:-1);
    }
}
