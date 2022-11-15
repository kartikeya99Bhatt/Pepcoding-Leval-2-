import java.io.*;
import java.util.*;

public class Main {
   

   public static void main(String[] args) throws Exception {
     Scanner scn=new Scanner(System.in);
     int n=scn.nextInt();
     int k=scn.nextInt();
      ArrayList<ArrayList<Integer>>list=new ArrayList<>();
      for(int i=0;i<k;i++){
          ArrayList<Integer>l=new ArrayList<>();
          l.add(scn.nextInt());
          l.add(scn.nextInt());
          list.add(l);
      }
      // write your code here
     int totalPair=solvePair(n,k,list);
     System.out.println(totalPair);
   }
  static int []parent;
  static int []rank;
  static int []size;
   public static int solvePair(int n,int k,ArrayList<ArrayList<Integer>>list){
       parent=new int[n];
       rank=new int[n];
       size=new int[n];
       for(int i=0;i<n;i++){
           parent[i]=i;
           rank[i]=0;
           size[i]=1;
       }
       for(ArrayList<Integer>l:list){
           int x=l.get(0);
           int y=l.get(1);
           int pofx=find(x);
           int pofy=find(y);
           if(pofx!=pofy){
               union(pofx,pofy);
           }
       }
         ArrayList<Integer>possibleAns=new ArrayList<>();
           for(int i=0;i<n;i++){
               if(parent[i]==i){
                   possibleAns.add(size[i]);
               }
           }
           int ans=0;
           for(int i=0;i<possibleAns.size();i++){
               for(int j=(i+1);j<possibleAns.size();j++){
                   ans+=(possibleAns.get(i))*(possibleAns.get(j));
               }
           }
           return ans;
   }
   public static int find(int x){
       if(parent[x]==x){
           return x;
       }
       parent[x]=find(parent[x]);
       return parent[x];
   }
   public static void union(int x,int y){
       if(rank[x]<rank[y]){
          parent[x]=y;
          size[y]+=size[x];
       }
       else if(rank[y]<rank[x]){
           parent[y]=x;
           size[x]+=size[y];
       }
       else{
            parent[y]=x;
            rank[x]++;
           size[x]+=size[y];
       }
   }

}

