 public static class Pair
    {
        int data;
        String bno;
        Pair(int data,String bno)
        {
            this.data=data;
            this.bno=bno;
        }
    }
    static ArrayList<String> generate(int N)
    {
        // Your code here
        Queue<Pair>pq=new ArrayDeque<>();
        ArrayList<String>ans=new ArrayList<>();
        pq.add(new Pair(1,"1"));
        while(pq.size()>0)
        {
            Pair temp=pq.remove();
            ans.add(temp.bno);
            if(2*temp.data<=N)
            {
               pq.add(new Pair(2*temp.data,temp.bno+'0')); 
            }
            if(2*temp.data+1<=N)
            {
                pq.add(new Pair(2*temp.data+1,temp.bno+'1'));
            }
        }
        return ans;
    }
