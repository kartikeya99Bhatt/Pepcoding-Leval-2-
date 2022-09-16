class Solution {
    long countStrings(int n) {
        // code here
        int MOD=1000000007;
        long zero=1%MOD;
        long one=1%MOD;
        
        for(int i=1;i<n;i++){
             long newzero=(zero%MOD+one%MOD)%MOD;
             one=zero%MOD;
             zero=newzero%MOD;
        }
        return (zero%MOD+one%MOD)%MOD;
    }
}
