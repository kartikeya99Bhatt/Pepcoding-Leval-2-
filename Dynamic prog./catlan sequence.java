
import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class Main
{
	public static void main (String[] args) throws java.lang.Exception
	{
		// your code goes here
        Scanner scn=new Scanner(System.in);
        int n=scn.nextInt();
        int []dp=new int[n+1];
        dp[0]=dp[1]=1;

        for(int i=2;i<=n;i++)
        {
            int left=0;
            int right=i-1;
            while(left<i)
            {
                dp[i]+=(dp[left]*dp[right]);
                left++;             right--;
            }
        }

        System.out.println(Arrays.toString(dp));
	}

}

