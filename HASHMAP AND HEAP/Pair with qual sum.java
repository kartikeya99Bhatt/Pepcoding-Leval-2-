import java.util.*;
 class Pair
{
  int x;
  int y;
  Pair(int x,int y)
  {
      this.x=x;
      this.y=y;
  }
}
 public class Main {

    public static void solution(int[] arr) {
        // write your code here
        HashMap<Integer,ArrayList<Pair>>map=new HashMap<>();
        
        for(int i=0;i<arr.length;i++)
        {
            for(int j=i+1;j<arr.length;j++)
            {
                int sum=arr[i]+arr[j];
                
                if(map.containsKey(sum)==true)
                {
                    for(Pair temp:map.get(sum))
                    {
                        if(temp.x!=i && temp.x!=j && temp.y!=i &&  temp.y!=j){
                            
                            System.out.println("The First Pair is : ("+arr[i]+"-"+i+","+arr[j]+"-"+j+")");
                            System.out.println("The Secound Pair is : ("+arr[temp.x]+"-"+temp.x+","+arr[temp.y]+"-"+temp.y+")");
                           
                        }
                    }
                     map.get(sum).add(new Pair(i,j));
                }
                else
                {
                  map.put(sum,new ArrayList<Pair>());
                  map.get(sum).add(new Pair(i,j));
                }
            }
        }
       
    }
    
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scn.nextInt();
        }
       solution(arr);
    }

}
