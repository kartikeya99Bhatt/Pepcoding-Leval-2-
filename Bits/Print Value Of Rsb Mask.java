 int n = scn.nextInt();

    //write your code here
    int mask=(n&(-n));
    System.out.println(Integer.toBinaryString(mask));
