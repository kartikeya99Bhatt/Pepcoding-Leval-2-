public class Solution {
    /**
     * @param intervals: an array of meeting time intervals
     * @return: the minimum number of conference rooms required
     */
    public int minMeetingRooms(List<Interval> intervals) {
        // Write your code here
        int []a=new int[intervals.size()];
        int []b=new int[intervals.size()];
       for(int i=0;i<intervals.size();i++){
           a[i]=intervals.get(i).start;
           b[i]=intervals.get(i).end;
       }
       Arrays.sort(a);
       Arrays.sort(b);
       int cnt=0;
       int ans=0;
         // logic
         int i=0,j=0;
         while(i<a.length && j<b.length)
         {
            if(a[i]<b[j])
            {
                i++;
                cnt++;
            }
            else{
                cnt--;
                j++;
            }
            ans=Math.max(ans,cnt);
         }
       return ans;
    }
}
