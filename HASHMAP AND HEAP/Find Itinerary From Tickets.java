import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int noofpairs_src_des = scn.nextInt();
		HashMap<String, String> map = new HashMap<>();
		for (int i = 0; i < noofpairs_src_des; i++) {
			String s1 = scn.next();
			String s2 = scn.next();
			map.put(s1, s2);	
		}

		//write your code here
    // FOR FINDING THE 
      HashSet<String>set=new HashSet<>();
      for(String str:map.keySet()){
              set.add(str);
      }
      
      for(String str:map.values()){
              set.remove(str);
      }
      StringBuilder ans=new StringBuilder("");
      String start=null;
      for(String str:set){
             start=str;
      }
      ans.append(start);
      
      
      while(map.containsKey(start)==true)
      {
          ans.append(" -> ");
          start=map.get(start);
          ans.append(start);
      }
      ans.append(".");
       System.out.println(ans);
	}
}
