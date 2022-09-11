class Solution{
    static int sortingCost(int N, int arr[]){
        // code here
        int []map=new int[N+1];
        for(int i=0;i<arr.length;i++){
            int value=arr[i];
            if(map[value-1]>0){
                map[value]=map[value-1]+1;
            }
            else{
                map[value]=1;
            }
        }
        int max=0;
        for(int val:map){
            max=Math.max(val,max);
        }
        return(N-max);
    }
}
