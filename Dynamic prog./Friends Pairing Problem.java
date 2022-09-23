class Solution
{
    public int countWays(int n, int m)
    {
        // Code here
        int []dp=new int[n+1];
        for(int i=1;i<n+1;i++){
            if(i<m){
                dp[i]=1;
            }
            else if(i==m){
                dp[i]=2;
            }
            else{
                dp[i]=(dp[i-1]%1000000007+dp[i-m]%1000000007)%1000000007;
            }
        }
        return dp[n];
    }
}
