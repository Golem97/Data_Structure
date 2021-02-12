
/******************************************************************************
*  @author Nathanael Benichou
*  https://github.com/Golem97
*  Data Structures 2020 - CS Ariel university
*  Exercise - 
******************************************************************************/
public class MyHashTable {

    class Node{
        private Integer key;
        private Student val;
        private Node next;
        public Node(Integer k, Student s){
            key  = k;
            val = s;
            next = null;
        }
    }

    private Node[] map;

    public MyHashTable(int size){
        map = new Node[size];
    }

    public Integer insert(Integer key, Student data){
        int t = hash(key);
        if(map[t]==null){
            map[t] = new Node(key, data);
        } 
        else{
            Node p=map[t];
            while(p!=null){
                if(key == p.key){
                    p.val.setName(data.getName());
                    return key;
                }
                if(p.next==null){
                   p.next = new Node(key, data); 
                   return key;
                } 
                p=p.next;
            }
        }
        return key;
    }

    private int hash(Integer key) {
        return key%map.length;
    }

    public Student remove(String key)
        Integer k = Integer.valueOf(key);
        int t = hash(ks);
        if(map[t].key.equals(k)){
            Student temp = map[t].val;
            map[t] = map[t].next;
            return temp;
        }
        for(Node p=map[t]; p.next!=null; p=p.next){
            if(p.next.key.equals(k)){
                Student temp = p.next.val;
                p.next = p.next.next;  
                return temp;
            } 
        }
        return null;
    }

    public Student get(String key){
        Integer k = Integer.valueOf(key);
        int t = hash(k);
        for(Node p=map[t]; p!=null; p=p.next)
            if(p.key.equals(k)) 
                return p.val;
        return null;
    }

    public String toString(){
        String t = "";
        for(int i=0; i<map.length; i++){
            t+= i+": ";
            for(Node p=map[i]; p!=null; p=p.next)
                t+= p.val +" -> ";
            t+= "null\n";
        }
        return t;
    }
}