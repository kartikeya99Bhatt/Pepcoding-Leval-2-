lass Solution {
    public int maxDistToClosest(int[] seats) {
        int pre=-1,curr=0;
        int ans=0;
        
        while(curr<seats.length)
        {
            if(seats[curr]==1)
            {
                if(pre==-1)
                {
                    ans=curr;
                    pre=curr;
                }
                else
                {
                   int mid=(curr-pre)/2;
                    ans=Math.max(ans,mid);
                    pre=curr;
                }
            }
            curr++;
        }
        if(seats[seats.length-1]==0)
        {
            ans=Math.max(ans,(seats.length-1-pre));
        }
        
        return ans;
    }
}
