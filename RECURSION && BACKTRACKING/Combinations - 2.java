QUESTION : There are N box and R items (N>R) R similar item 
NOTE : ITEM WILL DECIDE IN WHICH BOX SHOULD IT HAVE TO PLACED

public static void combinations(int[] boxes, int ci, int ti, int lb){
    // write your code here
    if(ci>ti)
    {
        for(int i=0;i<boxes.length;i++)
        {
            if(boxes[i]==1)
            System.out.print("i");
            
            else
            System.out.print("-");
        }
        System.out.println();
        return ;
    }
    for(int i=lb+1;i<boxes.length;i++)
    {
        boxes[i]=1;
        combinations(boxes,ci+1,ti,i);
        boxes[i]=0;
    }
  }
