class RandomizedCollection {

    HashMap<Integer,HashSet<Integer>>map;
    ArrayList<Integer>list;
    Random rand;
    public RandomizedCollection() {
        map=new HashMap<>();
        list=new ArrayList<>();
        rand=new Random();
    }
    
    public boolean insert(int val) {
        if(map.containsKey(val)==true)
        {
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
    
    public boolean remove(int val) {
        if(map.containsKey(val))
        {
            int v1=val;
            int v1idx=map.get(val).iterator().next();

            int v2idx=list.size()-1;
            int v2=list.get(v2idx);

            list.set(v1idx,v2);
            list.set(v2idx,v1);

            list.remove(v2idx);

            map.get(v1).remove(v1idx);
            if(map.get(v1).size()==0){
                map.remove(v1);
            }
         if(map.containsKey(v2))
         {
            map.get(v2).remove(v2idx);
            map.get(v2).add(v1idx);
         }
            return true;
        }
        else
        {
            return false;
        }
       
    }
    
    public int getRandom() {
        int value=rand.nextInt(list.size());
        return list.get(value) ;
    }
}

/**
 * Your RandomizedCollection object will be instantiated and called as such:
 * RandomizedCollection obj = new RandomizedCollection();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */
