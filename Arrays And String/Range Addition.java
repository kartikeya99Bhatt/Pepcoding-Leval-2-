public int[] getModifiedArray(int length, int[][] updates) {
        // Write your code here
        int []ans=new int[length];
        for(int i=0;i<updates.length;i++)
        {
            ans[updates[i][0]]+=updates[i][2];
            if(updates[i][1]+1!=length)
            ans[updates[i][1]+1]-=updates[i][2];
        }
        for(int i=1;i<ans.length;i++)
        {
            ans[i]+=ans[i-1];
        }
        return ans;
    }
