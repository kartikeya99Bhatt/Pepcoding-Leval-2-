class LRUCache {
    public class Node
    {
        int key;
        int value;
        Node pre;
        Node next;
        
        Node(int key,int value)
        {
            this.key=key;
            this.value=value;
            pre=next=null;
        }
    }
    Node head;
    Node tail;
    int cap;
    int size;
    
    public void addFirst(int key,int value)
    {
        Node temp=new Node(key,value);
        
        if(size==0)
        {
            head=tail=temp;
        }
        else
        {
            temp.next=head;
            head.pre=temp;
            head=temp;
        }
        size++;
    }
    
    public void remove(Node temp)
    {
        if(temp==head)
        {
            head=head.next;
            temp=temp.next;
            
        }
        else if(temp==tail)
        {
            tail=tail.pre;
            tail.next=null;
        }
        else
        {
            Node fow=temp.next;
            Node bef=temp.pre;
            bef.next=fow;
            fow.pre=bef;
        }
        size--;
    }
    HashMap<Integer,Node>map;
    LRUCache(int capacity) {
        this.cap=capacity;
        map=new HashMap<>();
    }
    
    int get(int key) {
        if(map.containsKey(key))
        {
            Node temp=map.get(key);
            remove(temp);
            addFirst(key,temp.value);
            map.put(key,head);
           
            return(temp.value);
        }
        else
        {
            return -1;
        }
    }
    
    void put(int key, int value) {
        if(map.containsKey(key))
        {
            Node temp=map.get(key);
            remove(temp);
        }
        else if(size==cap)
        {
            map.remove(tail.key);
            remove(tail);
            
        }
        addFirst(key,value);
        map.put(key,head);
    }
    
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache* obj = new LRUCache(capacity);
 * int param_1 = obj->get(key);
 * obj->put(key,value);
 */
