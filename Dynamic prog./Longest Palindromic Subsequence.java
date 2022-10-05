class Solution {
    public int longestPalindromeSubseq(String s) {
        int [][]dp=new int[s.length()][s.length()];
        
        for(int g=0;g<s.length();g++)
        {
            for(int i=0,j=g;j<s.length();i++,j++)
            {
                if(g==0)
                {
                    dp[i][j]=1;
                }
                else
                {
                    if(s.charAt(i)==s.charAt(j))
                    {
                        dp[i][j]=dp[i+1][j-1]+2;
                    }
                    else
                    {
                        dp[i][j]=Math.max(dp[i][j-1],dp[i+1][j]);
                    }
                }
            }
        }
        return dp[0][s.length()-1];
    }
}