class Solution {
    public boolean canPartition(int[] nums) {
        int sum=0;
        for(int val:nums){
            sum+=val;
        }
        if(sum%2==1){
            return false;
        }
        else
        {
            int target=sum/2;
            System.out.println(target);
            boolean [][]dp=new boolean[nums.length+1][target+1];
            
            for(int i=0;i<dp.length;i++)
            {
                for(int j=0;j<=target;j++)
                {
                    if(i==0 && j==0)
                    {
                       dp[i][j]=true; 
                    }
                    else if(j==0)
                    {
                        dp[i][j]=true;
                    }
                    else if(i==0)
                    {
                        dp[i][j]=false;
                    }
                    else
                    {
                        int curr=nums[i-1];
                        dp[i][j]=dp[i-1][j];
                        if(dp[i][j]==false && j>=curr)
                        {
                           dp[i][j]=dp[i-1][j-curr];
                        }
                    }
                    
                }
            }
           
            return(dp[dp.length-1][target]);
            
        }
        
        
    }
}
