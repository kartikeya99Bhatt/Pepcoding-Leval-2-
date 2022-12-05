class Solution {
    public int findKthNumber(int m, int n, int k) {
        int lo=1;int hi=m*n;
        while(lo<hi)
        {
            int mid=lo+(hi-lo)/2;
            int j=n;int actual=0;
            for(int i=1;i<=m;i++){
                
                while(j>=1 && i*j>mid)
                {
                    j--;
                }
                actual+=(j);
            }
            if(actual>=k)
            {
                hi=mid;
            }
            else
            {
                lo=mid+1;
            }
        }
        return lo;
    }
}
