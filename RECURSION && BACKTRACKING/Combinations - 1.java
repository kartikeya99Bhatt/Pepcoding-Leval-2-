Question: There are total n boxes and we need to place r similar item in it (n>r)
NOTE: BOX WILL DECIDE ->PLACE ->NOT PLACE 

Solutions:
public static void combinations(int cb, int tb, int ssf, int ts, String asf){
    // write your code here
    if(cb>tb)
    {
        if(ssf==ts)
        {
            System.out.println(asf);
        }
        return ;
    }
    combinations(cb+1,tb,ssf+1,ts,asf+"i");
    combinations(cb+1,tb,ssf,ts,asf+"-"); 
