import java.io.*;
import java.util.*;

public class Main {
        
    public static long partitionKSubset(int n, int k) {
        // write your code here
        if(n==0 || k==0 || k>n)
        {
            return 0;
        }
        long [][]dp=new long[k+1][n+1];
        for(int j=1;j<=k;j++)
        {
            for(int i=1;i<=n;i++)
            {
                if(j==1 || i==j)
                {
                    dp[j][i]=1;
                }
                else if(i<j)
                {
                   dp[j][i]=0; 
                }
                else
                dp[j][i]=j*dp[j][i-1]+dp[j-1][i-1];
            }
        }
        
        return (dp[k][n]);
    }
    
    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int k = scn.nextInt();
        
        long res = partitionKSubset(n, k);
        System.out.println(res);
    }
}
