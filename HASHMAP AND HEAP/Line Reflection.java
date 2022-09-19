import java.util.* ;
import java.io.*; 
public class Solution {
    public static boolean lineReflection(int[][] points) {
        // Write your code here.
        int min=Integer.MAX_VALUE;
        int max=Integer.MIN_VALUE;
        for(int i=0;i<points.length;i++){
            min=Math.min(min,points[i][0]);
            max=Math.max(max,points[i][0]);
        }
        int mid=min+max;
        HashSet<String>set=new HashSet<>();
        for(int i=0;i<points.length;i++)
        {
            set.add(points[i][0]+"#"+points[i][1]);
        }
        for(int i=0;i<points.length;i++)
        {
           String s=points[i][0]+"#"+points[i][1];
            int ximg=mid-points[i][0];
            String s2=ximg+"#"+points[i][1];
                if(set.contains(s) && set.contains(s2))
                {
                    set.remove(s);
                    set.remove(s2);
                }
        }
     
        return( (set.size()==0) ?true:false);
  }
}
