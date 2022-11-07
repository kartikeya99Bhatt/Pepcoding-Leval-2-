static int[] parent;
  static int[] rank;

  public static class Pair implements Comparable<Pair> {
    int u;
    int v;
    int wt;

    Pair(int u, int v, int wt) {
      this.u = u;
      this.v = v;
      this.wt = wt;
    }

    @Override
    public int compareTo(Pair o) {
      return this.wt - o.wt;
    }
  }

  public static int minCostToSupplyWater(int n, int[][] pipes) {
      parent=new int[n];
      rank=new int[n];
     for(int i=0;i<n;i++){
         parent[i]=i;
         rank[i]=0;
     }
     PriorityQueue<Pair>pq=new PriorityQueue<>();
     for(int i=0;i<pipes.length;i++)
     {
         pq.add(new Pair(pipes[i][0],pipes[i][1],pipes[i][2]));
     }
     int sum=0;
     while(pq.size()>0)
     {
        Pair p=pq.remove();
        int p1=find(p.u);
        int p2=find(p.v);
        
        if(p1!=p2)
        {
            System.out.println("The edge is "+p.u+" "+p.v+" "+p.wt);
            union(p1,p2);
            sum+=p.wt;
        }
     }
     
    return sum;
  }
  public static  int find(int ch)
  {
      if(ch==parent[ch])
      {
          return ch;
      }
    
        parent[ch]=find(parent[ch]);
        return(parent[ch]);
  }
  public static void union(int p1,int p2)
  {
      if(rank[p1]<rank[p2])
      {
          parent[p1]=p2;
      }
      else if(rank[p2]<rank[p1])
      {
        parent[p2]=p1;  
      }
      else
      {
         parent[p1]=p2;
         rank[p2]++;
      }
  }
}
