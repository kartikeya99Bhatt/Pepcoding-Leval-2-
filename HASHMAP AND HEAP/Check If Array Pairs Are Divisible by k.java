class Solution {
    public boolean canArrange(int[] arr, int k) {
        int count=0;
        int []nums=new int[k];
        for(int val:arr){
            int rem=(val%k<0?val%k+k:val%k);
            nums[rem]++;
        }
        if(nums[0]%2!=0){return false;}
        for(int i=1;i<=k/2;i++){
            if(nums[i]!=nums[k-i]){
                return false;
            }
        }
        return true;
    }
}
