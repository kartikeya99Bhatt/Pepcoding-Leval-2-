class Solution {
    class Pair implements Comparable<Pair>
    {
        int pos;
        int sp;
        Pair(int pos,int sp){
            this.pos=pos;
            this.sp=sp;
        }
        public int compareTo(Pair o)
        {
            return (o.pos-this.pos);
        }
    }
    public int carFleet(int target, int[] position, int[] speed) {
        PriorityQueue<Pair>pq=new PriorityQueue<>();
        for(int i=0;i<position.length;i++)
        {
            pq.add(new Pair(position[i],speed[i]));
        }
        
        Double preTime=null;
        int grpCount=0;
        while(pq.size()>0)
        {
            Pair temp=pq.remove();
            Double currTime=(target-temp.pos)*1.0/temp.sp;
            if(preTime==null || currTime>preTime)
            {
                preTime=currTime;
                grpCount++;
            }
            
        }
        return grpCount;
    }
}
