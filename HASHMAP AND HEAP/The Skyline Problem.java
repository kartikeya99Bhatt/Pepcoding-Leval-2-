class Solution {

    public List<List<Integer>> getSkyline(int[][] buildings) {
        List<List<Integer>>ans=new ArrayList<>();
        
        int [][]arr=new int[2*(buildings.length)][2];
        int idx=0;
        for(int i=0;i<buildings.length;i++)
        {
            int st=buildings[i][0];
            int ed=buildings[i][1];
            int ht=buildings[i][2];
            arr[idx][0]=st;
            arr[idx][1]=-ht;
            idx++;
            arr[idx][0]=ed;
            arr[idx][1]=ht;
            idx++;
        }
        Arrays.sort(arr,(a,b)->{
            if(a[0]==b[0])
            {
                return(a[1]-b[1]);
            }
            return(a[0]-b[0]);
        });
       
        for(int i=0;i<arr.length;i++){
            System.out.println(arr[i][0]+"  "+arr[i][1]);
        }
        PriorityQueue<Integer>pq=new PriorityQueue<>(Collections.reverseOrder());
        pq.add(0);
        int currht=0;
        for(int i=0;i<arr.length;i++)
        {
            if(arr[i][1]<0)
            {
                pq.add(-1*arr[i][1]);
            }
            else
            {
                pq.remove(arr[i][1]);
            }
            if(currht!=pq.peek())
            {
                List<Integer>list=new ArrayList<>();
                list.add(arr[i][0]);
                list.add(pq.peek() );
                ans.add(list);
            }
             currht=pq.peek();
           
        }
        
        
        return ans;
    }
}
