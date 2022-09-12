class FreqStack {
     
    HashMap<Integer,Stack<Integer>>map;
    HashMap<Integer,Integer>fmap;
    
    int mfst=1;
    public FreqStack() {
        map=new HashMap<>();
        fmap=new HashMap<>();
    }
    
    public void push(int val) {
       fmap.put(val,fmap.getOrDefault(val,0)+1);
       int bucket=fmap.get(val);
        if(map.containsKey(bucket)==true){
            map.get(bucket).push(val);
        }
        else{
            map.put(bucket,new Stack<>());
            map.get(bucket).push(val);
        }
        mfst=Math.max(mfst,bucket);
    }
    
    public int pop() {
        int value=map.get(mfst).pop();
        if(fmap.get(value)>1){
            fmap.put(value,fmap.getOrDefault(value,0)-1);
        }
        else
        {
            fmap.remove(value);
        }
        if(map.get(mfst).size()==0){
            mfst--;
        }
        return value;
    }
}

/**
 * Your FreqStack object will be instantiated and called as such:
 * FreqStack obj = new FreqStack();
 * obj.push(val);
 * int param_2 = obj.pop();
 */
