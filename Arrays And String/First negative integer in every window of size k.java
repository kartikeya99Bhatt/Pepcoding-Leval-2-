

//User function Template for Java


class Compute {
    
    public long[] printFirstNegativeInteger(long A[], int N, int k)
    {
       long []ans=new long[N-k+1];
       int j=0;
       for(int i=0;i<=N-k;i++)
       {
           if(j<i)
           {
               j=i;
           }
           while(j<i+k-1 && A[j]>0)
           {
               j++;
           }
           if(A[j]<0)
           {
               ans[i]=A[j];
           }
       }
       return ans; 
    }
}
