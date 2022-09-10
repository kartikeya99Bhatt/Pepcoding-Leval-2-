import java.util.*;
public class Main{

 public static void main(String[]args){
 Scanner scn=new Scanner(System.in);
  int t=scn.nextInt();
   while(t-->0)
    {
       int n=scn.nextInt();
       int []arr=new int[n];
       for(int i=0;i<n;i++){
           arr[i]=scn.nextInt();
       }
       solve(arr);
    
    }
 }
 public static void solve(int []arr)
 {
     HashMap<Integer,Integer>map=new HashMap<>();
     long count=0;
     for(int i=0;i<arr.length;i++){
       map.put(arr[i]-i,map.getOrDefault(arr[i]-i,0)+1);
     }
     for(int val:map.keySet())
     {
         int cnt=map.get(val);
         count+=((cnt)*(cnt-1))/2;
     }
     System.out.println(count);
 }




}
