 public static void main(String[] args){
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();
    int i = scn.nextInt();
    int j = scn.nextInt();
    int k = scn.nextInt();
    int m = scn.nextInt();
    
    //write your code here
    int mask=1<<i;
    System.out.println( (n|mask) );
    mask=1<<j;
    System.out.println((n&(~mask)));
    
    mask=1<<k;
    System.out.println((n^mask));
    
    mask=1<<m;
    if((n&mask)>0)
    System.out.println("true");
    else
    System.out.println("false");
 
  }
