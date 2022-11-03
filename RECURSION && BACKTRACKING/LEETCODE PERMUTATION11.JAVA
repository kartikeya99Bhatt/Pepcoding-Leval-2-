class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
           Arrays.sort(nums);   
            List<List<Integer>>ans=new ArrayList<>();
            List<Integer>list=new ArrayList<>();
            backTrack(nums,new boolean[nums.length],ans,list,0);
            return ans;
    }
    public void backTrack(int []nums,boolean []used,List<List<Integer>>ans,List<Integer>list,int csf)
    {
        if(csf==nums.length)
        {
            ans.add(new ArrayList<>(list));
            return ;
        }
        for(int i=0;i<nums.length;i++)
        {
            if(i>0 &&  nums[i]==nums[i-1] && used[i-1]==true){continue;}
           else if(used[i]==false)
            {
                used[i]=true;
                list.add(nums[i]);
                backTrack(nums,used,ans,list,csf+1);
                list.remove(list.size()-1);
                used[i]=false;
           }
            
        }
    }
}
