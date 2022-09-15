import java.util.*;

public class Main {
	
    public static void completeTask(int n, int m, int[] arr) {
		// write your code here
		int []Newarr=new int[n+1];
		for(int val:arr)
		{
		    Newarr[val]++;
		}
		boolean f1=false;
		ArrayList<Integer>s1=new ArrayList<>();
		ArrayList<Integer>s2=new ArrayList<>();
		for(int i=1;i<=n;i++)
		{
		    if(Newarr[i]==0)
		    {
		        if(f1==false)
		        {
		            s1.add(i);
		            f1=true;
		        }
		        else if(f1==true)
		        {
		            s2.add(i);
		            f1=false;
		        }
		    }
		}
		
		for(int val:s1)
      {
          System.out.print(val+" ");
      }
      System.out.println();
      for(int val:s2)
      {
          System.out.print(val+" ");
      }

	}

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		int m = scn.nextInt();
		int[] num = new int[m];
		for (int i = 0; i < m; i++) {
			num[i] = scn.nextInt();
		}
		completeTask(n, m, num);
	}

}
