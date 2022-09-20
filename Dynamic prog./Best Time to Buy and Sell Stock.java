class Solution {
    public int maxProfit(int[] price) {
         int profit=0;
        int bp=price[0];
        for(int i=1;i<price.length;i++)
        {
            bp=Math.min(bp,price[i]);
            int currPro=price[i]-bp;
            profit=Math.max(profit,currPro);
        }
        return profit;
    }
}
