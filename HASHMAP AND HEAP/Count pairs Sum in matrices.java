class Solution {
    int countPairs(int mat1[][], int mat2[][], int n, int x) {
        // code here
        int size=n*n-1;
        int leftBno=0;int rightBno=n*n-1;int ans=0;
        while(leftBno<=size && rightBno>=0)
        {
            int lr=leftBno/n; int rr=rightBno/n;
            int lc=leftBno%n; int rc=rightBno%n;
            
            int sum=mat1[lr][lc]+mat2[rr][rc];
            
            if(sum==x){
                ans++;leftBno++;rightBno--;
            }
            else if(sum>x){
                rightBno--;
            }
            else{
                leftBno++;
            }
        }
        return ans;
    }
}
