import java.util.*;

public class Main {

	public static int solution(String str) {
		// write your code here
		int count=0;
		HashSet<Character>set=new HashSet<>();
		int j=0;
		for(int i=0;i<str.length();i++)
		{
		    char ch=str.charAt(i);
		    if(set.contains(ch)==false)
		    {
		        set.add(ch);
		        count+=i-j+1;
		    }
		    else
		    {
		       while(str.charAt(j)!=ch)
		       {
		           set.remove(str.charAt(j));
		           j++;
		       }
		       j++;
		        count+=i-j+1;
		    }
		}
		
		return count;
	}
	
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		String str = scn.next();
		System.out.println(solution(str));
	}

}
