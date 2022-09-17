 import java.util.*;
 public class Main
 {


     static int[] LIS(int[] arr)
    {
       int []dp=new int[arr.length];
       int len=1;
       dp[0]=arr[0];
      for(int i=1;i<arr.length;i++)
      {
          if(arr[i]>=dp[len-1])
          {
              dp[len]=arr[i];
               len++;
          }
          else
          {
              int idx=binarySearch(dp,arr[i],len-1);
              System.out.println("The idx value is " + idx+"The length is "+len);
              if(idx<0)
              {
                idx=-idx;
                idx=idx-1;
              }
              else
              {
                idx+=1;
              }
              dp[idx]=arr[i];
          }
      }

      return dp;
    }
    public static int binarySearch(int []arr,int val,int hi)
    {
       int lo=0;
       int ans=-1;
       int ans2=-1;

       while(lo<=hi)
       {
           int mid=(lo+hi)/2;
           if(arr[mid]==val)
           {
               ans=mid;
               lo=mid+1;
           }
           else if(arr[mid]<val)
           {
             lo=mid+1;
             ans2=-(lo+1);
           }
           else if(arr[mid]>val)
           {
              hi=mid-1;
              ans2=-(hi+2);
           }
       }
        return( (ans==-1)?ans2:ans );
    }
         

          public static void main(String []args)
          {
              int []a={2,7,3,1,3};
             int []ans=LIS(a);
             for(int val:ans)
             {
                 System.out.print(val+" ");
             }
          }
 }
 
