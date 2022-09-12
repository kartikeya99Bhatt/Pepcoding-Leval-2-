import java.util.*;
public class GFG{
public static void main(String []args){
Scanner scn=new Scanner(System.in);
 int [][]arr={{8,1},{1,2},{4,3},{3,4},{5,5},{2,6},{6,7},{7,8}};
  System.out.println(maxBuildingBridges(arr));
 }
 public static int maxBuildingBridges(int [][]arr)
 {
        Arrays.sort(arr,(a,b)->{
         if(a[0]!=b[0]) // sort on the basic of north 
         {
             return(a[0]-b[0]);
         }
         else // sort on the basic of south 
         {
             return(a[1]-b[1]);
         }
     });
     
     // lcs
     int []lcs=new int[arr.length];
     lcs[0]=1;
     for(int i=1;i<arr.length;i++)
     {
         int max=0;
         for(int j=0;j<i;j++)
         {
             if(arr[i][1]>=arr[j][1])
             max=Math.max(max,lcs[j]);
         }
         lcs[i]=max+1;
     }
     
     int ans=0;
     for(int val:lcs){
         ans=Math.max(ans,val);
     }
     return(ans);
 }
}
