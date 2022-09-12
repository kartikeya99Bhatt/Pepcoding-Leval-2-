class Solution{
    class Pair{
        Integer fq=null;
        Integer fi=null;
        Integer li=null;
        Pair(Integer fq,Integer fi,Integer li){
            this.fq=fq;
            this.fi=fi;
            this.li=li;
        }
    }
  
    ArrayList<Integer> smallestSubsegment(int a[], int n)
    {
        // Complete the function
        HashMap<Integer,Pair>map=new HashMap<>();
        Integer mfe=null;
        for(int i=0;i<a.length;i++)
        {
            int val=a[i];
            if(map.containsKey(val)==false){
                map.put(val,new Pair(1,i,i));
            }
            else{
                Pair temp=map.get(val);
                temp.fq++;
                temp.li=i;
            }
            if(mfe==null || map.get(mfe).fq<map.get(val).fq || ( map.get(mfe).fq==map.get(val).fq &&  map.get(mfe).li-map.get(mfe).fi  > i-map.get(val).fi) ){
                mfe=val;
            }
            
        }
        int stidx=map.get(mfe).fi;
        int edidx=map.get(mfe).li;
        ArrayList<Integer>ans=new  ArrayList<>();
        for(int i=stidx;i<=edidx;i++){
            ans.add(a[i]);
        }
        return(ans);
    }
}
