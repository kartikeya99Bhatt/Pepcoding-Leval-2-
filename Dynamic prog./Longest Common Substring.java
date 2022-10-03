class Solution{
    int longestCommonSubstr(String s1, String s2, int n, int m){
        // code here
        int [][]dp=new int[n+1][m+1];
        // s1 coloumn 
        // s2 row
        int max=0;
        for(int i=0;i<n+1;i++)
        {
            for(int j=0;j<m+1;j++)
            {
                if(i==0 || j==0)
                {
                    dp[i][j]=0;
                }
                else if(s1.charAt(i-1)==s2.charAt(j-1))
                {
                    dp[i][j]=dp[i-1][j-1]+1;
                    max=Math.max(dp[i][j],max);
                }
            }
        }
        return max;
    }
