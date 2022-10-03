class Solution {
    public String longestPalindrome(String s) {
     int n=s.length();
        int [][]dp=new int[n][n];
        int max=0;
        String ans="";
        for(int g=0;g<n;g++)
        {
            for(int i=0,j=g;j<n;j++,i++)
            {
                if(g==0)
                {
                    dp[i][j]=1;
                }
                else if(g==1)
                {
                    if(s.charAt(i)==s.charAt(j))
                    {
                        dp[i][j]=1;
                    }
                }
                else
                {
                    if(s.charAt(i)==s.charAt(j) && dp[i+1][j-1]==1)
                    {
                        dp[i][j]=1;

                      }
                }
                
                if(dp[i][j]==1)
                {
                    ans=s.substring(i,j+1);
                }
            }
        }
        return ans;
    }
}

