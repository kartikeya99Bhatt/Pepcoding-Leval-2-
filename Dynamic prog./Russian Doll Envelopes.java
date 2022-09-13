class Solution {
    public int maxEnvelopes(int[][] envelopes) {
        Arrays.sort(envelopes,(a,b)->{
            if(a[0]!=b[0])
           return(a[0]-b[0]);
            else
                return(b[1]-a[1]);
        });
       
        int []tails=new int[envelopes.length];
        tails[0]=envelopes[0][1];
        int len=1;
        for(int i=1;i<envelopes.length;i++)
        {
            int value=envelopes[i][1];
            if(value>tails[len-1])
            {
                tails[len]=value;
                len++;
            }
            else
            {
                int idx=Arrays.binarySearch(tails,0,len-1,value);
                if(idx<0)
                {
                    idx=Math.abs(idx)-1;
                }
                tails[idx]=value;
            }
        }
        return len;
    }
}

/*
[4,5] [4,6] [6,7] 
*/
