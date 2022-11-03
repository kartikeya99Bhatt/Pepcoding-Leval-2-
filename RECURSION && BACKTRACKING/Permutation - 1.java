Question : There are n boxes and r item where (n>r) how many ways r item can be placed in n boxes 
NOTE : item has choice which box to select 

solution:

public static void permutations(int[] boxes, int ci, int ti){
    // write your code here
    if(ci>ti)
    {
        for(int val:boxes)
        System.out.print(val);
        
        System.out.println();
        return ;
    }
    for(int i=0;i<boxes.length;i++)
    {
        if(boxes[i]==0)
        {
            boxes[i]=ci;
            permutations(boxes,ci+1,ti);
            boxes[i]=0;
        }
    }
