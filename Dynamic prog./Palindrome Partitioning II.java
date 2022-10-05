class Solution {
    boolean [][]ip;
   void isPalindrome(String s){
           ip=new boolean[s.length()][s.length()];
        for(int g=0;g<s.length();g++)
        {
            for(int i=0,j=g;j<s.length();i++,j++)
            {
                if(g==0)
                {
                    ip[i][j]=true;
                }
                else if(g==1)
                {
                    ip[i][j]=( s.charAt(i)==s.charAt(j) );
                }
                else
                {
                    ip[i][j]=(s.charAt(i)==s.charAt(j)) && ip[i+1][j-1];
                }
            }
        }
    }
    public int minCut(String s) 
    {
       isPalindrome(s);
       return(partion(s));
    }
    int partion(String s)
    {
        if(s.length()==1)
        {
            return 0;
        }
        int []dp=new int[s.length()];
        dp[0]=0;
        dp[1]=(s.charAt(0)==s.charAt(1))?0:1;
        
        for(int j=2;j<s.length();j++)
        {
             dp[j]=j;
             if(ip[0][j])
             {
                dp[j]=0;    
             }
            else{
                for(int i=j;i>=1;i--)
                {
                    if(ip[i][j])
                    {
                        int prefix=dp[i-1];
                        dp[j]=Math.min(dp[j],prefix+1); 
                        System.out.println(dp[j]+"yes");
                    }
                }
            }
        }
        return (dp[s.length()-1]);
    }
}
