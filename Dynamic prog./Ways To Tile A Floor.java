class Solution {
    static Long numberOfWays(int N) {
        // code here
        Long []dp=new Long[N+1];
        for(int i=1;i<=N;i++){
            if(i==1){
                dp[i]=1L;
            }
            else if(i==2)
            {
                
                dp[i]=2L;
            }
            else
            {
                dp[i]=(dp[i-1]%1000000007+dp[i-2]%1000000007)%1000000007;
            }
        }
        return dp[N];
    }
};
