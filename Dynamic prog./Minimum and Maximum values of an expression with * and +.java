import java.util.*;
public class Main
{
    public static int evaluate(char op,int v1,int v2)
    {
        if(op=='+')
        {
            return(v1+v2);
        }
        else 
        {
           return (v1*v2);
        }
    }
    public static  int fun(int []nums,char []op)
    {
        int n=nums.length;
        int [][]dp=new int[n][n];
        

        for(int g=0;g<n;g++)
        {
            for(int i=0,j=g;j<n;i++,j++)
            {
                if(g==0)
                {
                   dp[i][j]=nums[j];
                }
                else if(g==1)
                {
                   dp[i][j]=evaluate(op[j-1],nums[i],nums[j]);
                }
                else 
                {
                    // bawal
                    int res=Integer.MIN_VALUE;
                    for(int k1=1,k2=g;k1<=g;k1++,k2--)
                    {
                       int left=dp[i][j-k2];
                       int right=dp[i+k1][j];
                       int cost=evaluate(op[j-k2],left,right);
                       res=Math.max(res,cost);
                    }
                    dp[i][j]=res;
                }
            }
        }

          for(int i=0;i<dp.length;i++)
          {
              for(int j=0;j<dp[i].length;j++)
              {
                  System.out.print(dp[i][j]+" ");
              }
              System.out.println();
          }

        return (dp[0][n-1]);
    }
    public static void main(String []args)
    {
        Scanner scn=new Scanner(System.in);
        int n=scn.nextInt();
        int []nums=new int[n];
        for(int i=0;i<nums.length;i++)
        {
            nums[i]=scn.nextInt();
        }
        String str="+*+*";
        char []ch=str.toCharArray();
         int max=fun(nums,ch);
        int min=fun2(nums,ch);
        System.out.println(max+" "+min);
    }
    

     public static  int fun2(int []nums,char []op)
    {
        int n=nums.length;
        int [][]dp=new int[n][n];
        

        for(int g=0;g<n;g++)
        {
            for(int i=0,j=g;j<n;i++,j++)
            {
                if(g==0)
                {
                   dp[i][j]=nums[j];
                }
                else if(g==1)
                {
                   dp[i][j]=evaluate(op[j-1],nums[i],nums[j]);
                }
                else 
                {
                    // bawal
                    int res=Integer.MAX_VALUE;
                    for(int k1=1,k2=g;k1<=g;k1++,k2--)
                    {
                       int left=dp[i][j-k2];
                       int right=dp[i+k1][j];
                       int cost=evaluate(op[j-k2],left,right);
                       res=Math.min(res,cost);
                    }
                    dp[i][j]=res;
                }
            }
        }

          for(int i=0;i<dp.length;i++)
          {
              for(int j=0;j<dp[i].length;j++)
              {
                  System.out.print(dp[i][j]+" ");
              }
              System.out.println();
          }

        return (dp[0][n-1]);
    }

}
