class Solution
{
    long countPS(String str)
    {
        // Your code here
        long MOD=1000000000+7;
        long [][]dp=new long[str.length()][str.length()];
        for(int g=0;g<str.length();g++)
        {
            for(int i=0,j=g;j<str.length();j++,i++)
            {
                if(g==0)
                {
                    dp[i][j]=1;
                }
                else
                {
                    if(str.charAt(i)==str.charAt(j))
                    {
                        dp[i][j]=(dp[i+1][j]+dp[i][j-1]+1)%MOD;
                    }
                    else
                    {
                        dp[i][j]=(dp[i+1][j]+dp[i][j-1]-dp[i+1][j-1]+MOD)%MOD;
                    }
                }
            }
        }
        return (dp[0][str.length()-1]);
    }
}
