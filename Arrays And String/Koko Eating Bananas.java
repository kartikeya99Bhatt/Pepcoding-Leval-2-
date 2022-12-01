class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int lo=1;
        int hi=0;
        for(int val:piles){
            hi=Math.max(hi,val);
        }
        
        while(lo<hi)
        {
            int mid=lo+(hi-lo)/2;
            int nohr=0;
            for(int i=0;i<piles.length;i++){
                nohr+=(int)Math.ceil(piles[i]*1.0/mid);
            }
            if(nohr<=h){
                hi=mid;
            }
            else{
                lo=mid+1;
            }
        }
        return lo;
    }
}
