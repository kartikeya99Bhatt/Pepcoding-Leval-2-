class Solution {
    HashMap<Character,Character>parent;
    HashMap<Character,Integer>rank;
    public boolean equationsPossible(String[] equations) {
       parent=new HashMap<>();
       rank=new HashMap<>();
         for(int i=0;i<equations.length;i++)
         {
             parent.put(equations[i].charAt(0),equations[i].charAt(0));
             parent.put(equations[i].charAt(3),equations[i].charAt(3));
             rank.put(equations[i].charAt(0),0);
             rank.put(equations[i].charAt(3),0);
         }
       for(int i=0;i<equations.length;i++)
       {
           if(equations[i].charAt(1)!='!')
           {
                unionHelper(equations[i].charAt(0),equations[i].charAt(3));
           }
       }
         for(int i=0;i<equations.length;i++)
       {
           if(equations[i].charAt(1)=='!')
           {
                if( find(equations[i].charAt(0))==find(equations[i].charAt(3)) )
                {
                    return false;
                }
           }
       }
        return true;
        
    }
    public void union(char x,char y)
    {
        if(rank.get(x)<rank.get(y))
        {
            parent.put(x,y);
        }
        else if(rank.get(y)<rank.get(x))
        {
            parent.put(y,x);
        }
        else
        {
           parent.put(x,y);
           rank.put(y,rank.get(y)+1);
        }
    }
    public char find(char x)
    {
        if( x==parent.get(x) )
        {
            return x;
        }
        char res=find(parent.get(x));
        parent.put(x,res);
        return res;
    }
    public void  unionHelper(char x,char y)
    {
        char pofx=find(x);
        char pofy=find(y);
        if(pofx!=pofy)
        {
            union(pofx,pofy);
        }
    }
    
}
