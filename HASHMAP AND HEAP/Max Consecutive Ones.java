class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int max=0;int curr=0;
        for(int val:nums){
            if(val==1){
                curr++;
            }
            else{
                curr=0;
            }
            max=Math.max(max,curr);
        }
        return max;
    }
}
