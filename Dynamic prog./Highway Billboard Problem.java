import java.util.Scanner;
public class Main{
    public static int solution(int m , int[] x, int[] rev, int t) {
       int omax=0;
       int []dp=new int[rev.length];
       dp[0]=rev[0];
       for(int i=1;i<x.length;i++)
       {
           int max=0;
           for(int j=0;j<i;j++)
           {
               if(x[j]+t<x[i])
               max=Math.max(max,dp[j]);
           }
           dp[i]=rev[i]+max;
           omax=Math.max(omax,dp[i]);
       }
      
        return omax;
    }
    public static void input(int []arr,Scanner scn){
        for(int i = 0;i<arr.length;i++){
            arr[i] = scn.nextInt();
        }
    }
    public static void main(String []args){
        Scanner scn = new Scanner(System.in);   
        int m = scn.nextInt();
        int n = scn.nextInt();
        
        int x[] = new int[n];
        input(x, scn);

        int revenue[] = new int[n];
        input(revenue,scn);

        int t = scn.nextInt();

        System.out.println(solution(m, x, revenue, t));
        scn.close();
    }
}
