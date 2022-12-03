public class Solution {
    public int books(ArrayList<Integer> A, int B) {
        if(A.size()<B)
        {
            return -1;
        }
        int lo=0;int hi=0;
        for(int i=0;i<A.size();i++)
        {
            lo=Math.max(lo,A.get(i));
            hi+=A.get(i);
        }
   
        while(lo<hi)
        {
            int mid=lo+(hi-lo)/2;
            int number=1;int sum=0;
            for(int i=0;i<A.size();i++)
            {
                if( (sum+A.get(i))<=mid)
                {
                  sum+=A.get(i);    
                }
                else
                {
                    number++;
                    sum=A.get(i);  
                }
            }
            if(number<=B)
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
