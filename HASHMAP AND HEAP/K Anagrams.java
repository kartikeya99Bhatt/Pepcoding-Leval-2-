QUESTION
Given two string s1 and s2 and a integer k ;
s1 is said to be k Anagram of s2 if after less then equal k changes in s1 we can achive s2 string;

// solution

import java.util.*;

public class Main {
	public static boolean areKAnagrams(String str1, String str2, int k) {
		// write your code here
		HashMap<Character,Integer>map1=new HashMap<>();
		for(char ch:str1.toCharArray())
		{
		    map1.put(ch,map1.getOrDefault(ch,0)+1);
		}
		int cnt=0;
		for(char ch:str2.toCharArray()){
		    if(map1.containsKey(ch)==false)
		    {
		        cnt++;
		    }
		    else
		    {
		       if(map1.get(ch)==1)
		       {
		           map1.remove(ch);
		       }
		       else
		       {
		           map1.put(ch,map1.get(ch)-1);
		       }
		    }
		}
     
		return (cnt<=k);
	}

	public static void main(String[] args) {

		Scanner s = new Scanner(System.in);
		String str1 = s.next();
		String str2 = s.next();
		int k = s.nextInt();
		System.out.println(areKAnagrams(str1, str2, k));

	}

}
