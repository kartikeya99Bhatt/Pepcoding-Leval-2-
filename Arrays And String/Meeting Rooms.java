public class Solution {
  public class pair implements Comparable<pair>
  {
      int st;int ed;
      pair(int st,int ed){
          this.st=st;
          this.ed=ed;
      }
      public int compareTo(pair o)
      {
          return (this.st-o.st);// increasing order;
      }

  }
    public boolean canAttendMeetings(List<Interval> intervals) {
        // Write your code here
        PriorityQueue<pair>pq=new PriorityQueue<>();
        for(int i=0;i<intervals.size();i++)
        {
            pq.add(new pair(intervals.get(i).start,intervals.get(i).end));
        }
        int start=-1;
        int end=-1;
        while(pq.size()>0)
        {
           pair temp=pq.remove();
           if(start==-1)
           {
               start=temp.st;
               end=temp.ed;
           }
           else if(temp.st>=end)
           {
               end=temp.ed;
           }
           else
           {
               return false;
           }
        }
        
        return true;
    }
}
