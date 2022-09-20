class Solution {
    public int maxProfit(int[] prices) {
        int bp=0;
        int sp=0;
        int profit=0;
        for(int i=1;i<prices.length;i++)
        {
            if(prices[i]>=prices[i-1])
            {
                sp++;
            }
            else
            {
                profit+=prices[sp]-prices[bp];
                sp=bp=i;
            }
        }
        if(sp!=bp)
        profit+=prices[sp]-prices[bp];
        return profit;
        
    }
}
