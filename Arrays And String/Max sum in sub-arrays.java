class Solution {
    
    public static long pairWithMaxSum(long arr[], long N)
    {
        // Your code goes here
        long max=0;
        for(int i=0;i<N-1;i++)
        {
            max=Math.max(max,arr[i]+arr[i+1]);
        }
        
        return max;
    }
}
