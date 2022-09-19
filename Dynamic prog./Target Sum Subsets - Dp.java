import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        
        Scanner scn=new Scanner(System.in);
        int n=scn.nextInt();
        int []arr=new int[n];
        for(int i=0;i<arr.length;i++)
        {
            arr[i]=scn.nextInt();
        }
        int target=scn.nextInt();
        System.out.println(Target_Sum_Subsets(arr,target));
    }
    public static boolean Target_Sum_Subsets(int []arr,int target)
    {
        boolean [][]dp=new boolean [arr.length+1][target+1];
        
        for(int i=0;i<dp.length;i++)
        {
            for(int j=0;j<=target;j++)
            {
                if(i==0 && j==0)
                {
                    dp[i][j]=true;
                }
                else if(j==0)
                {
                    dp[i][j]=true;
                }
                else if(i==0)
                {
                    dp[i][j]=false;
                }
                else
                {
                    int curr=arr[i-1];
                    dp[i][j]=dp[i-1][j];
                    if(dp[i][j]==false && j>=curr)
                    {
                        dp[i][j]=dp[i-1][j-curr];
                    }
                }
            }
        }
        
        return (dp[dp.length-1][target]);
    }
}
