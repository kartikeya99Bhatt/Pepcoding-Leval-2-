public class Solution {
    /**
     * @param sticks: the length of sticks
     * @return: Minimum Cost to Connect Sticks
     */
    public int minimumCost(List<Integer> sticks) {
        // write your code here
        int sum=0;
       PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
        for(int val:sticks){
            pq.add(val);
        }
        while(pq.size()>=2)
        {
            int v1=pq.remove();
            int v2=pq.remove();
            int tempSum=v1+v2;
            sum+=tempSum;
            pq.add(tempSum);
        }
        return sum;
    }
}
