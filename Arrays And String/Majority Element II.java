class Solution {
    public List<Integer> majorityElement(int[] nums) {
        int cnt1=0 ;Integer ele1=null;
        int cnt2=0 ;Integer ele2=null;

        for(int i=0;i<nums.length;i++)
        {
          if(ele1==null && ( ele2==null || nums[i]!=ele2))
          {
            ele1=nums[i];
            cnt1=0;
          }
          else if(ele2==null && (ele1==null || nums[i]!=ele1))
          {
            ele2=nums[i];
            cnt2=0;
          }

          if(ele1!=null && nums[i]==ele1)
          {
             cnt1++;
          }
          else if(ele2!=null && nums[i]==ele2)
          {
             cnt2++;
          }
          else
          {
            cnt1--;
            cnt2--;
            if(cnt1==0)
            {
               ele1=null;
            }
            if(cnt2==0)
            {
              ele2=null;
            }
          }
        }
        
        // need to check are they really a majority element 
        List<Integer> ans=new ArrayList<Integer>();
        if(ele1==null && ele2==null)
        {
          return ans;
        }
        cnt1=0; cnt2=0;
        for(int i=0;i<nums.length;i++)
        {
          if(ele1!=null && nums[i]==ele1)
          {
            cnt1++;
          }
          else if(ele2!=null && nums[i]==ele2)
          {
            cnt2++;
          }
        }
        
        if(cnt1>nums.length/3){
          ans.add(ele1);
        }
        if(cnt2>nums.length/3){
          ans.add(ele2);
        }
        return ans;
    }
}
