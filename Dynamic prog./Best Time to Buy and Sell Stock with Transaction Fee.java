class Solution {
    public int maxProfit(int[] prices, int fee) {
     
        int bsp=-prices[0];
        int ssp=0;
        for(int i=1;i<prices.length;i++)
        {
            int newbsp=Math.max(bsp,ssp-prices[i]);
            int newssp=Math.max(ssp,bsp+prices[i]-fee);
            
            bsp=newbsp;
            ssp=newssp;    
        }
        return ssp;
    }
}
