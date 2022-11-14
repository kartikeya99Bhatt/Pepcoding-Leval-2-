class Solution
{
    //Function to find the minimum number of swaps required to sort the array.
    public int minSwaps(int nums[])
    {
        // Code here
        HashMap<Integer,Integer>map=new HashMap<>();
        for(int i=0;i<nums.length;i++){
            map.put(nums[i],i);
        }
        boolean []visited=new boolean[nums.length];
        int cntSwapNumber=0;
        Arrays.sort(nums);
        for(int i=0;i<nums.length;i++)
        {
            if(visited[i]==false){
                cntSwapNumber+=cntSwap(map,visited,nums,i);
            }
        }
        return cntSwapNumber;
    }
    public int cntSwap(HashMap<Integer,Integer>map,boolean []visited,int []nums,int idx)
    {
        int cnt=1;
        int st=idx;
        visited[idx]=true;
        int curr=map.get(nums[idx]);
        while(curr!=st)
        {
            visited[curr]=true;
            cnt++;
            curr=map.get(nums[curr]);
        }
        return cnt-1;
    }
}
