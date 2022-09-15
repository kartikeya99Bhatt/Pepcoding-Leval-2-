import java.io.*;
import java.util.*;

public class Main {

  public static void main(String[] args){
    Scanner scn = new Scanner(System.in);
    int n = Integer.parseInt(scn.nextLine());


    //write your code here
    HashMap<String,ArrayList<String>>tree=new HashMap<>();
    String root="";
    for(int i=0;i<n;i++)
    {
       String[] parts =scn.nextLine().split(" ");
        
        if(  parts[0].equals(parts[1]) )
        {
            root=parts[0];
        }
        else if(tree.containsKey(parts[1]) )
        {
            tree.get(parts[1]).add(parts[0]);
        }
        else
        {
          tree.put(parts[1],new ArrayList<>());
          tree.get(parts[1]).add(parts[0]);
        }
        
    }
    
    HashMap<String,Integer>list=new HashMap<>();
    Size(tree,root,list);
    for(String key:list.keySet())
    {
        System.out.println(key+" "+list.get(key));
    }
  }
   public static int Size(HashMap<String,ArrayList<String>>tree,String root,HashMap<String,Integer>list)
   {
       if(tree.containsKey(root)==false)
       {
         list.put(root,0);
         return 1;
       }
       int sz=0;
       for(String child:tree.get(root))
       {
           int cs=Size(tree,child,list);
           sz+=cs;
       }
       list.put(root,sz);
       return sz+1;
   }


}
