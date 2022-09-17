import java.io.*;
import java.util.*;

public class Main{

public static void main(String[] args) throws Exception {
    // write your code here
    Scanner scn=new Scanner(System.in);
    int n=scn.nextInt();
    
    int []dp=new int[n+1];
    dp[0]=dp[1]=1;
    
    for(int i=2;i<=n;i++)
    {
        for(int left=0;left<i;left++)
        {
             int right=i-left-1;
                dp[i]+=(dp[left]*dp[right]);
        }
    }
    System.out.println(dp[n]);
 }

}
