class Solution
{
    //Function to find the minimum number of platforms required at the
    //railway station such that no train waits.
    static int findPlatform(int arr[], int dep[], int n)
    {
        // add your code here
        Arrays.sort(arr);
        Arrays.sort(dep);
        int i=0;int j=0;int maxCount=0;
        int currCount=0;
        while(i<arr.length)
        {
            if(arr[i]<=dep[j])
            {
                currCount++;
                i++;
                maxCount=Math.max(maxCount,currCount);
            }
            else if(arr[i]>dep[j])
            {
                currCount--;
                j++;
            }
        }
        
        return maxCount;
    }
    
}
