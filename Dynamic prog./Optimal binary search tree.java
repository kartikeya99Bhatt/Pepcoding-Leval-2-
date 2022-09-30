class Solution
{
    static int optimalSearchTree(int keys[], int freq[], int n)
    {
        // code here
        int [][]dp=new int[n][n];
        int []psa=new int[n];
        int ps=0;
        for(int i=0;i<psa.length;i++)
        {
            ps=psa[i]=(ps+freq[i]);
        }
        for(int g=0;g<n;g++)
        {
            for(int i=0,j=g;j<n;i++,j++)
            {
                if(g==0)
                {
                    dp[i][j]=freq[i];
                }
                else if(g==1)
                {
                    dp[i][j]=Math.min((freq[i]*1+freq[j]*2),(freq[i]*2+freq[j]*1));
                }
                else
                {
                    int min=Integer.MAX_VALUE;
                    for(int k1=1,k2=g+1;k2>=1;k1++,k2--)
                    {
                         int left=(j-k2==-1)?0:dp[i][j-k2];
                         int right=(i+k1==n)?0:dp[i+k1][j];
                         int factor=psa[j]-(i-1>=0?psa[i-1]:0);
                         min=Math.min(min,left+right+factor);
                    }
                    dp[i][j]=min;
                }
            }
        }
        return (dp[0][n-1]);
    }
}
