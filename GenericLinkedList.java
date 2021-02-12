
/******************************************************************************
*  @author Nathanael Benichou
*  https://github.com/Golem97
*  Data Structures 2020 - CS Ariel university
*  Exercise 8 - implementation of a generic LinkedList 
******************************************************************************/
public class GenericLinkedList<T> {

    class Node{
        private T key;
        private Node next;

        public Node(T key){
            this.key = key;
            this.next = null;
        }
        public T key(){
            return key;
        }
        public String toString(){
            return "key: "+key;
        }
    }

    private Node head;
    private Node tail;
    private int  size;

    public GenericLinkedList(){
        head=tail=null;
        size=0;
    }

    public void add(T key){
        Node newNode = new Node(key);
        if(head == null) head = newNode;
        else             tail.next = newNode;
        tail = newNode;
        size++;
    }

    // public void addLast(T key){
    //     Node<T> newNode = new Node<>(key);
    //     if(size==0) head = newNode;
    //     else             tail.next = newNode;
    //     tail = newNode;
    //     size++;
    // }

    public T removeFirst(){
        if(head == null) return null;
        T temp = head.key();
        head = head.next;
        size--;
        return temp;
    }

    public T removeLast(){
        if(size==0) return null;
        if(size==1){
            T temp = tail.key();
            size--;
            head = tail = null;
            return temp; 
        } 
        T temp = tail.key();
        for(Node p=head; p!=null; p=p.next){
            if(p.next == tail){
                p.next = null;
                tail = p;
            }
        }
        size--;
        return temp;
    }

    public Node remove(T key){
        Node p;
        if(head.key.equals(key)){
            Node temp = head;
            if(size == 1){
               head = tail = null; 
               return temp;
            } 
            head=head.next;
            size--;
            return temp;
        } 
        for(p = head; p.next!=null; p=p.next){
            if(p.next.key.equals(key)){
                Node temp = p.next;
                p.next = p.next.next;
                size--;
                if(p.next == null){
                    tail = p;
                    return temp;
                }  
            }
        }
        return null;
    }

    public Node search(T key) {
        for(Node p=head; p!=null; p=p.next)
            if(p.key.equals(key)) return p;
        return null;
    }

    public Node at(int i) {
        for(Node p=head; p!=null; p=p.next, i--)
            if(i==0) return p;
        return null;
    }

    public T    get(int i) {
        for(Node p=head; p!=null; p=p.next, i--)
            if(i==0) return p.key;
        return null;
    }

    public int size(){
        return size;
    }

    public boolean isEmpty(){
        return size==0;
    }

    public String toString(){
        if(head == null) return "Size: 0";
        String t = "[";
        for(Node p = head; p!=null; p=p.next)
            t+= p.key+" -> ";
        return t+"null] Size:"+size+" Head: "+head.key+" Tail: "+tail.key;
    }

}