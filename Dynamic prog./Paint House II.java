public class Solution {
    /**
     * @param costs: n x k cost matrix
     * @return: an integer, the minimum cost to paint all houses
     */
    public int minCostII(int[][] cost) {
        if(cost.length==0)
        {
            return 0;
        }
        // write your code here
        int toatal_house=cost.length;
        int kOption=cost[0].length;
        int [][]dp=new int[toatal_house][kOption];
        int pmin=Integer.MAX_VALUE;
        int psmin=Integer.MAX_VALUE;
       for(int i=0;i<kOption;i++)
       {
           dp[0][i]=cost[0][i];
           if(dp[0][i]<pmin)
           {
               psmin=pmin;
               pmin=dp[0][i];
           }
           else if(dp[0][i]<psmin)
           {
               psmin=dp[0][i];
           }
       }

       for(int i=1;i<toatal_house;i++)
       {
           int cmin=Integer.MAX_VALUE;
           int csmin=Integer.MAX_VALUE;
           for(int j=0;j<kOption;j++)
           {
               if(dp[i-1][j]!=pmin)
               {
                    dp[i][j]=cost[i][j]+pmin;
               }
               else
               {
                     dp[i][j]=cost[i][j]+psmin;
               }

               if(dp[i][j]<cmin)
                {
                    csmin=cmin;
                    cmin=dp[i][j];
                }
                else if(dp[i][j]<csmin)
                {
                    csmin=dp[i][j];
                }
           }
           pmin=cmin;
           psmin=csmin;
       }
      int ans=Integer.MAX_VALUE;
      for(int i=0;i<kOption;i++)
      {
          ans=Math.min(ans,dp[toatal_house-1][i]);
      }
      return ans;
    }
}
