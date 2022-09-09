class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        int sum=0;
        int ans=0;
        HashMap<Integer,Integer>map=new HashMap<>();
        map.put(0,1);
        for(int val:nums){
            sum+=val;
            int mod=sum%k;
            mod=mod<0?mod+k:mod;
            if(map.containsKey(mod)){
                   ans+=map.get(mod);
            }
            map.put(mod,map.getOrDefault(mod,0)+1);   
        }
        return ans;
    }
}
