public class Solution {
    /**
     * @param a: lists A
     * @param b: lists B
     * @return: the index mapping
     */
    public int[] anagramMappings(int[] a, int[] b) {
        // Write your code here
        HashMap<Integer,ArrayList<Integer>>map=new HashMap<>();
        for(int i=0;i<b.length;i++){
            if(map.containsKey(b[i])==false){
                map.put(b[i],new ArrayList<>());
                map.get(b[i]).add(i);
            }
            else{
                
                 map.get(b[i]).add(i);
            }
        }
        int []ans=new int[a.length];
        for(int i=0;i<a.length;i++){
            int val=map.get(a[i]).get(0);
            ans[i]=val;
            map.get(a[i]).remove(0);
        }
        return ans;
    }
}
