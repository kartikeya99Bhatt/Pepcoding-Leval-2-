

//User function Template for Java

class Solution
{
    // arr[]: Input Array
    // N : Size of the Array arr[]
    //Function to count inversions in the array.
    static long ans=0;
    static long inversionCount(long arr[], long N)
    {
        // Your Code Here
        ans=0;
        mergeSort(arr,0,N-1);
        return ans;
    }
    public static  long[] mergeSort(long []arr,long lo,long hi)
    {
        if(lo==hi)
        {
            long []base=new long[1];
            base[0]=arr[(int)lo];
            return base;
        }
        long mid=(lo+hi)/2;
        long []a=mergeSort(arr,lo,mid);
        long []b=mergeSort(arr,mid+1,hi);
        long []c=mergeTwoSortedArray(a,b);
        return c;
    }
    public static long[] mergeTwoSortedArray(long []a,long []b){
        long []c=new long[a.length+b.length];
        long i=0;long j=0;long k=0;
        while(i<a.length && j<b.length)
        {
            if(a[(int)i]<=b[(int)j])
            {
                c[(int)k]=a[(int)i];
                i++;
                k++;
            }
            else
            {
                c[(int)k]=b[(int)j];
                ans+=(a.length-i);
                j++;
                k++;
            }
        }
        while(i<a.length)
        {
             c[(int)k]=a[(int)i];
                i++;
                k++;
        }
        while(j<b.length)
        {
            c[(int)k]=b[(int)j];
                j++;
                k++; 
        }
        return c;
    }
}
