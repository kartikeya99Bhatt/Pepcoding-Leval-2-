class Solution {
    public int maxProfit(int[] prices) {
        
       int []mtnfl=new int[prices.length]; // max till now from left
       int lfl=prices[0]; // least from left
       mtnfl[0]=0;
       int mfl=0; // max from left
       
        for(int i=1;i<prices.length;i++)
        {
            lfl=Math.min(prices[i],lfl);
            mfl=Math.max(prices[i]-lfl,mfl);
            mtnfl[i]=mfl;
        }
        
        
        int []mtnfr=new int[prices.length]; // max till now from right 
        mtnfr[prices.length-1]=0;
        int mfr=prices[prices.length-1]; // max from right amoung prices
        int mtn=0;// max till now from right
        
        for(int i=prices.length-2;i>=0;i--)
        {
            mfr=Math.max(mfr,prices[i]);
            mtn=Math.max(mtn,mfr-prices[i]);
            mtnfr[i]=mtn;
        }
        
        int max=0;
        for(int i=0;i<mtnfr.length;i++)
        {
            max=Math.max(max,mtnfr[i]+mtnfl[i]);
        }
        return max;
        
    }
}
