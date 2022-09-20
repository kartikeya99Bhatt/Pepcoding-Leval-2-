class Solution {
    public int maxProfit(int[] prices) {
        
        int bsp=-prices[0];
        int ssp=0;
        int csp=0;
        
        for(int i=1;i<prices.length;i++)
        {
            int newbsp=Math.max(bsp,csp-prices[i]);
            int newssp=Math.max(ssp,prices[i]+bsp);
            int newcsp=Math.max(ssp,csp);
            
            bsp=newbsp;
            ssp=newssp;
            csp=newcsp;
        }
        
        return ssp;
        
    }
}
