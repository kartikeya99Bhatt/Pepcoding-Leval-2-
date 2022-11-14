import java.util.*;
public class Solution {
public static class  Pair  implements Comparable<Pair>
{
    int ver;
    int nbr;
    int cost;
    Pair(int ver,int nbr,int cost){
        this.ver=ver;
        this.nbr=nbr;
        this.cost=cost;
    }
    public int compareTo(Pair o){
        return  (this.cost-o.cost);
    }
}
    public static int supplyWater(int n, int k, int[] wells, int[][] pipes) {
        // Write your code here
        PriorityQueue<Pair>pq=new PriorityQueue<>();
        int parentVertex=n+1;
        for(int i=1;i<=n;i++){
            pq.add(new Pair(i,parentVertex,wells[i-1]));
        }
        for(int i=0;i<pipes.length;i++){
            pq.add(new Pair(pipes[i][0],pipes[i][1],pipes[i][2]));
        }
        int totalCost=0;
        parent=new int[parentVertex+1];
        rank=new int[parentVertex+1];
        for(int i=0;i<parent.length;i++){
            parent[i]=i;
            rank[i]=0;
        }
        while(pq.size()>0){
            Pair temp=pq.remove();
            int x=temp.ver;
            int y=temp.nbr;
            int pofx=find(x);
            int pofy=find(y);
            if(pofx!=pofy){
                union(pofx,pofy);
                totalCost+=temp.cost;
            }
        }
        return totalCost;
    }
    static int  []parent;
   static int []rank;
    public static  int find(int x){
        if(x==parent[x]){
            return x;
        }
        parent[x]=find(parent[x]);
        return parent[x];
    }
    public static  void union(int x,int y){
        if(rank[x]<rank[y])
        {
            parent[x]=y;
        }
        else if(rank[y]<rank[x])
        {
            parent[y]=x;
        }
        else
        {
            parent[x]=y;
            rank[y]++;
        }
    }
    
}
