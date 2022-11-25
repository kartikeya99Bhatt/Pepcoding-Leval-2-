class Solution {
    boolean hasArrayTwoCandidates(int arr[], int n, int target) {
        // code here
        Arrays.sort(arr);
        int i=0;int j=n-1;
        while(i<j)
        {
            int sum=arr[i]+arr[j];
            if(sum==target)
            {
                return true;
            }
            else if(sum>target)
            {
                j--;
            }
            else
            {
                i++;
            }
        }
        return false;
    }
}
