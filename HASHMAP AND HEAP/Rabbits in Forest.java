class Solution {
    public int numRabbits(int[] answers) {
        HashMap<Integer,Integer>map=new HashMap<>();
        for(int val:answers){
            map.put(val,map.getOrDefault(val,0)+1);
        }
        int count=0;
        for(int val:map.keySet()){
            count+=(int)( Math.ceil(map.get(val)*1.0/(val+1)) )*(val+1);
        }
        return count;
    }
}
