class Solution {
    public int[][] intervalIntersection(int[][] f, int[][] s) {
        
        int i=0;
        int j=0;
        ArrayList<int[]>list=new ArrayList<>();
        while(i<f.length && j<s.length)
        {
            int []interval=new int[2];
            interval[0]=Math.max(f[i][0],s[j][0]);
            interval[1]=Math.min(f[i][1],s[j][1]);
            if(interval[0]<=interval[1])
            {
                list.add(interval);
            }
            if(f[i][1]<s[j][1])
            {
                i++;
            }
            else
            {
                j++;
            }
        }
        int [][]ans=new int[list.size()][2];
        for( i=0;i<list.size();i++){
            ans[i]=list.get(i);
        }
        return ans;
    }
}
