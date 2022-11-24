// USING TWO ARRAY OF PAIR 
class Solution {
    class Pair implements Comparable<Pair>
    {
        int val;
        int cap;
        Pair(int val,int cap)
        {
            this.val=val;
            this.cap=cap;
        }
        public int compareTo(Pair o)
        {
            return(this.val-o.val);
        }
    }
    public boolean carPooling(int[][] trips, int capacity) {
        Pair[]arr=new Pair[trips.length];
        Pair[]dep=new Pair[trips.length];
        
        for(int i=0;i<trips.length;i++)
        {
            arr[i]=new Pair(trips[i][1],trips[i][0]);
            dep[i]=new Pair(trips[i][2],trips[i][0]);
        }
        
        Arrays.sort(arr);
        Arrays.sort(dep);
       
        int i=0;int j=0;int count=0;
        while(i<arr.length && j<dep.length)
        {
            if(arr[i].val<dep[j].val)
            {
                count+=arr[i].cap;
                if(count>capacity)
                {
                    return false;
                }
                i++;
            }   
            else
            {
                count-=dep[j].cap;
                j++;
            }
         

        }
        return true;
    }
}

// using priorityQueue
class Solution {
    public class Pair implements Comparable<Pair>
    {
        int time;
        int delta;
        Pair(int time,int delta)
        {
           this.time=time;
            this.delta=delta;
        }
        public int compareTo(Pair o){
            if(this.time!=o.time){
              return (this.time-o.time);
            }
            else 
            {
               return (this.delta-o.delta);
            }
        }
    }
    public boolean carPooling(int[][] trips, int capacity) {
        PriorityQueue<Pair>pq=new PriorityQueue<>();
        for(int []arr:trips)
        {
            pq.add(new Pair(arr[1],+arr[0]));
            pq.add(new Pair(arr[2],-arr[0]));
        }
        int currCapacity=0;
        while(pq.size()>0)
        {
            Pair temp=pq.remove();
             
               if(temp.delta>0)
               {
                   currCapacity+=temp.delta;
                   if(currCapacity>capacity)
                   {  
                       return false;
                   }
               }
            else if(temp.delta<0)
            {
                currCapacity=currCapacity+temp.delta;
            }
        }
        return true;
    }
}
