import java.util.* ;
import java.io.*; 
public class Solution {
	public static int minimumSwaps(int n, int[] A, int[] B) {
		// Write your code here.
        HashMap<Integer,Integer>map=new HashMap<>();
        for(int i=0;i<A.length;i++){
            map.put(A[i],i);
        }
        boolean []visited=new boolean[n];
        int cntMinSwap=0;
        for(int i=0;i<n;i++)
        {
            if(visited[i]==false && A[i]!=B[i]){
               cntMinSwap+=countSwap(map,B,visited,i,A); 
            }
        }
        return cntMinSwap;
	}
    public static int countSwap(HashMap<Integer,Integer>map,int []B,boolean []visited,int idx,int []A)
    {
        int cnt=1;
        int st=idx;
        visited[idx]=true;
        int curr=map.get(B[idx]);
        while(st!=curr)
        {    cnt++;
             visited[curr]=true;
             curr=map.get(B[curr]);
        }
        return cnt-1;
    }
}
