class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        
        ArrayList<int[]>list=new ArrayList<>();
        int i=0;
        
        
        // part 1
        
            while(i<intervals.length && intervals[i][1]<newInterval[0] )
            {
                list.add(intervals[i]);
                    i++;
            }
        
        // part 2
         int []interval=newInterval;
              while(i<intervals.length && intervals[i][0]<=interval[1])
                {
                    interval[0]=Math.min(intervals[i][0], interval[0]);
                    interval[1]=Math.max(intervals[i][1], interval[1]);
                 i++;
               }
           list.add(interval);
        
         // part 3
          while(i< intervals.length && intervals[i][0]>newInterval[1])
            {
                list.add(intervals[i]);
                    i++;
            }
        
        int [][]ans=new int[list.size()][2];
        for( i=0;i<list.size();i++)
        {
            int []temp=list.get(i);
            ans[i][0]=temp[0];
            ans[i][1]=temp[1];   
        }
        return ans;
    }
}
