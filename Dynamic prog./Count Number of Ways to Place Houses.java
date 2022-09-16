class Solution {
    public int countHousePlacements(int n) {
        int MOD=1000000007;
        long space=1;
        long building =1;
        for(int i=1;i<n;i++){
            long newBuilding=(space%MOD+building%MOD)%MOD;
            space=building;
            building=newBuilding;
        }
        long val=(building%MOD+space%MOD)%MOD;
        long ans=(val%MOD*val%MOD)%MOD;
        return (int)ans;
    }
}
