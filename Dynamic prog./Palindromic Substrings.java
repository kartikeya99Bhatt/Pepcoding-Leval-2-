class Solution {
    public int countSubstrings(String s) {
        
        int n=s.length();
        int [][]dp=new int[n][n];
        int count=0;
        for(int g=0;g<n;g++)
        {
            for(int i=0,j=g;j<n;j++,i++)
            {
                if(g==0)
                {
                    dp[i][j]=1;
                    count++;
                }
                else if(g==1)
                {
                    if(s.charAt(i)==s.charAt(j))
                    {
                        dp[i][j]=1;
                        count++;
                    }
                }
                else
                {
                    if(s.charAt(i)==s.charAt(j) && dp[i+1][j-1]==1)
                    {
                        dp[i][j]=1;
                        count++;
                    }
                }
            }
        }
        return count;
    }
}
