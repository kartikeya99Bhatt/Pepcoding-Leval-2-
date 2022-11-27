class Solution {
    public int findMinArrowShots(int[][] points) {
        
        Arrays.sort(points,(a,b)->{
            if(a[0]>b[0])
            {
                return 1;
            }
            else if(a[0]==b[0])
            {
                return 0;
            }
            else
            {
                return -1;
            }
           
        });
        int count=0;
        int i=0;
       while(i<points.length)
        {
            count++;
            int []interval=points[i];
            while(i<points.length && points[i][0]<=interval[1])
            {
                interval[0]=Math.max(interval[0], points[i][0]);
                interval[1]=Math.min(interval[1], points[i][1]);
                i++;
            }
        }
        
        return count;
    }
}
