class Solution {
    public int maxProfit(int k, int[] prices) {
        if(k==0 || prices.length==0)
           {
               return 0;
           }
        int [][]dp=new int[k+1][prices.length];
        for(int i=1;i<=k;i++){
            int max=Integer.MIN_VALUE;
            for(int j=1;j<prices.length;j++){
                max=Math.max(max,dp[i-1][j-1]-prices[j-1]);
                dp[i][j]=Math.max(dp[i][j-1],max+prices[j]);
            }
        }
        return (dp[k][prices.length-1]);
    }
}
