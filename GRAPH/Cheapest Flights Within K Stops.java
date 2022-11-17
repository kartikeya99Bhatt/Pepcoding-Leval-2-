class Solution {
    public int findCheapestPrice(int n, int[][] flights, int scr, int dst, int k) {
        int []d=new int[n];
        Arrays.fill(d,Integer.MAX_VALUE);
        d[scr]=0;
        int[] newd=new int[n];
        for(int i=0;i<=k;i++)
        {
            newd=d.clone();
            for(int j=0;j<flights.length;j++)
            {
                int from=flights[j][0];
                int to=flights[j][1];
                int ct=flights[j][2];
                System.out.println(d[from]);
                    if(d[from]!=Integer.MAX_VALUE)
                    {
                        int nwcst=d[from]+ct;
                        if(newd[to]>nwcst)
                         newd[to]=nwcst;
                    }
            }
            d=newd;
            System.out.println();
        }
       
        return( (d[dst]!=Integer.MAX_VALUE) ? d[dst] :-1 );
            
    }
}
