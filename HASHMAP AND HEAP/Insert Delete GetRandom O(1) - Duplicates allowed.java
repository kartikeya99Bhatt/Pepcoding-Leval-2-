class RandomizedCollection {

    HashMap<Integer,HashSet<Integer>>map;
    List<Integer>list;
    Random r=new Random();
    public RandomizedCollection() {
        map=new HashMap<>();
        list=new ArrayList<>();
    }
    
    public boolean insert(int val) {
        
        if(map.containsKey(val)==true){
            map.get(val).add(list.size());
            list.add(val);
            return false;
        }
        else
        {
            map.put(val,new HashSet<>());
            map.get(val).add(list.size());
            list.add(val);
            return true;
        }
    }
    
    public boolean remove(int val)
    {
       
        if(map.containsKey(val))
        {
            int iff=map.get(val).iterator().next();
            int vf=val;
            
            int il=list.size()-1;
            int vl=list.get(list.size()-1);
            
            swap(iff,il);
            list.remove(list.size()-1);
            
            map.get(vf).remove(iff);
            if(map.get(vf).size()==0)
            {
                map.remove(vf);
            }
            if(map.containsKey(vl)){
            map.get(vl).remove(il);
            map.get(vl).add(iff);
            }
            return true;
        }
        else
        {
            return false;
        }
    }
    
    public int getRandom() {
        int val=r.nextInt(list.size());
            return list.get(val);
    }
    
    public void swap(int i,int j){
    int vi=list.get(i);
    int vj=list.get(j);
    list.set(i,vj);
    list.set(j,vi);
   }
}

/**
 * Your RandomizedCollection object will be instantiated and called as such:
 * RandomizedCollection obj = new RandomizedCollection();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */
