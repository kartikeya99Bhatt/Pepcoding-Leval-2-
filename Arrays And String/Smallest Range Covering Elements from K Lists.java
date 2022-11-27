class Solution {
    
    public int[] smallestRange(List<List<Integer>> nums) {
        int max=Integer.MIN_VALUE;
        int []ans=new int[2];
        int rs=Integer.MAX_VALUE;
        PriorityQueue<pair>pq=new PriorityQueue<>();
        
        for(int i=0;i<nums.size();i++)
        {
            max=Math.max(max,nums.get(i).get(0));
            pq.add(new pair(i,0,nums.get(i).get(0)));
        }
        while(true)
        {
            pair temp=pq.remove();
            if((max-temp.value)<rs)
            {
                rs=max-temp.value;
                ans[0]=temp.value;
                ans[1]=max;
            }
            int newidx=temp.idx+1;
            if( newidx>=(nums.get(temp.li).size()) )
            {
                break;
            }
            temp.idx=newidx;
            temp.value=nums.get(temp.li).get(newidx);
            max=Math.max(max,temp.value);
            pq.add(temp);
        }
        return ans;
    }
    class pair implements Comparable<pair>
    {
        int li;
        int idx;
        int value;
        pair(int li,int idx,int value)
        {
            this.li=li;
            this.idx=idx;
            this.value=value;
        }
        public int compareTo(pair o)
        {
            return(this.value-o.value);
        }
    }
}
