class Solution {
    public int countPrimes(int n) {
        boolean []isPrime=new boolean[n+1];
        for(int div=2;div*div<=n;div++)
        {
            if(isPrime[div]==true)
            {
                continue;
            }
            for(int j=div;div*j<n+1;j++)
            {
                isPrime[div*j]=true;
            }
        }
        int count=0;;
        for(int i=2;i<n;i++)
        {
            if(isPrime[i]==false)
            {
                count++;
            }
        }
        return count;
    }
}
