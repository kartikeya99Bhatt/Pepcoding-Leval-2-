// DFS
class Solution {
    public boolean isBipartite(int[][] graph) {
        Integer[] arr=new Integer[graph.length];
    
         for(int i=0;i<graph.length;i++)
         {
             if(arr[i]==null)
             {
                 boolean ans=solve(i,graph,0,arr);
                 if(ans==false)
                 {
                     return false;
                 }
             }
         }
        return true;
    }
    public boolean solve(int scr,int [][]graph,int assign,Integer[]arr)
    {
        if(arr[scr]==null)
        {
             arr[scr]=assign;
        }
        else
        {
            if(assign==arr[scr])
            {
                return true;
            }
            else
            {
                return false;
            }
        }
       
        for(int i=0;i<graph[scr].length;i++)
        {
            int nbr=graph[scr][i];
            if(assign==1){
            boolean falg= solve(nbr,graph,0,arr);
            if(falg==false)
            {
                return false;
            }
            }
             else if(assign==0){
            boolean falg= solve(nbr,graph,1,arr);
            if(falg==false)
            {
                return false;
            }
            }
        }
        return true;
    }
}
//BFS
class Solution {
     class Pair
     {
         int val;
         int idx;
         Pair(int val,int idx)
         {
             this.val=val;
             this.idx=idx;
         }
     }
    public boolean isBipartite(int[][] graph) {
        Integer[] arr=new Integer[graph.length];
    
         for(int i=0;i<graph.length;i++)
         {
             if(arr[i]==null)
             {
                 boolean ans=solve(i,graph,arr);
                 if(ans==false)
                 {
                     return false;
                 }
             }
         }
        return true;
    }
    public boolean solve(int scr,int [][]graph,Integer[]arr)
    {
        Queue<Pair>pq=new ArrayDeque<>();
        pq.add(new Pair(scr,0));
        while(pq.size()>0)
        {
            // remove
            Pair temp=pq.remove();
            //mark 
            if(arr[temp.val]==null)
            {
                arr[temp.val]=temp.idx;
            }
            else
            {
                if(temp.idx!=arr[temp.val])
                {
                    return false;
                }
                else
                {
                    continue;
                }
            }
            //work
            //add childern
            for(int i=0;i<graph[temp.val].length;i++)
            {
                int nbr=graph[temp.val][i];
                if(temp.idx==0)
                pq.add(new Pair(nbr,1));
                else if(temp.idx==1)
                pq.add(new Pair(nbr,0));    
            }
        }
        return true;
    }
}
