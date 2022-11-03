Question: box has choice to decide that to whome he want to make sit

public static void permutations(int cb, int tb, boolean[] items, int ssf, int ts, String asf){
    // write your code here
    if(cb>tb)
    {
        if(ssf==ts)
        System.out.println(asf);
        
        return ;
    }
     for(int i=0;i<items.length;i++)
     {
         if(items[i]==false)
         {
             items[i]=true;
             permutations(cb+1,tb,items,ssf+1,ts,asf+(i+1));
             items[i]=false;
         }
     }
     permutations(cb+1,tb,items,ssf,ts,asf+"0");
