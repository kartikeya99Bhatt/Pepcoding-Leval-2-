class RandomizedSet {

    HashMap<Integer,Integer>map;
    ArrayList<Integer>list;
    Random r;
    public RandomizedSet() {
        map=new HashMap<>();
        list=new ArrayList<>();
        r=new Random();
    }
    
    public boolean insert(int val) {
       if(map.containsKey(val)==false){
            map.put(val,list.size());
            list.add(val);
          return true;
       }
        else
        {
            return false;
        }
    }
    
    public boolean remove(int val) {
        if(map.containsKey(val)==true){
            
            swap(map.get(val),list.size()-1);
            list.remove(list.size()-1);
            map.remove(val);
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
    map.put(vj,i);
}

}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */
