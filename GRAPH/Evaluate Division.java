class Solution {
    HashMap<String,String>parent;
    HashMap<String,Double>mul;
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries)    {
        parent=new HashMap<>();
        mul=new HashMap<>();
        for(List<String> eq:equations)
        {
            addToMap(eq.get(0));
            addToMap(eq.get(1));
        }
        int idx=0;
         for(List<String> eq:equations)
        {
            String p1=find(eq.get(0));
            String p2=find(eq.get(1));
            
            if(p1.equals(p2)==false)
            {
                 // union
                 double mo=mul.get(eq.get(0));
                 double m1=mul.get(eq.get(1));
                 
                 parent.put(p1,p2);
                 mul.put(p1,(values[idx]*m1/mo) );
            }
             idx++;
        }
      
        System.out.println(mul);
        double []res=new double[queries.size()];
        idx=0;
         for(List<String> eq:queries)
        {
           String qo=eq.get(0);
           String q1=eq.get(1);
           if(parent.containsKey(qo)==false || parent.containsKey(q1)==false)
           {
               res[idx++]=-1.0;
              continue;
           }
            String po=find(qo);
            String p1=find(q1);
            if(po.equals(p1)==false)
            {
               res[idx++]=-1.0; 
                continue;
            }
             else
             {
                 double vo=mul.get(qo);
                 double v1=mul.get(q1);
                 System.out.println(vo+"  "+v1);
                 res[idx++]=vo/v1; 
             }
            
        }
        return res;
    }
    public String find(String x){
        if(x.equals(parent.get(x)))
        {
            return x;
        }
        String currpar=parent.get(x);
        String finalpar=find(currpar);
        parent.put(x,finalpar);
        mul.put(x,mul.get(x)*mul.get(currpar));
        return finalpar;
    }
    public void addToMap(String x){
        parent.put(x,x);
        mul.put(x,1.0);
    }
}
