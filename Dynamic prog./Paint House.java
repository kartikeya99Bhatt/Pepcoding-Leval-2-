public class Solution {
    /**
     * @param costs: n x 3 cost matrix
     * @return: An integer, the minimum cost to paint all houses
     */
    public int minCost(int[][] cost) {
        if(cost.length==0)
        {
            return 0;
        }
        // write your code here
        int [][]dp=new int[cost.length][cost[0].length];
        for(int i=0;i<cost[0].length;i++){
            dp[0][i]=cost[0][i];
        }
        for(int i=1;i<cost.length;i++)
        {
            for(int j=0 ;j<cost[i].length;j++)
            {
                  // find min;
                  if(j==0)
                 dp[i][j]=cost[i][j]+Math.min(dp[i-1][1],dp[i-1][2]);
                 else if(j==1)
                 dp[i][j]=cost[i][j]+Math.min(dp[i-1][0],dp[i-1][2]);
                 else if(j==2)
                 dp[i][j]=cost[i][j]+Math.min(dp[i-1][0],dp[i-1][1]);
            }
        }
        return( Math.min(dp[dp.length-1][2],Math.min(dp[dp.length-1][0],dp[dp.length-1][1]) ) );

    }
}
