
/******************************************************************************
*  @author Nathanael Benichou
*  https://github.com/Golem97
*  Data Structures 2020 - CS Ariel university
*  Exercise 8 - implementation of a cyclic LinkedList
******************************************************************************/
public class CycledLinkedList<T> {

    class Node {
        private T key;
        private Node next;

        public Node(T key) {
            this.key = key;
            this.next = null;
        }

        public String toString() {
            return "key: " + key;
        }
    }

    private Node head;
    private Node tail;
    private int size;

    public CycledLinkedList() {
        head=tail=null;
        size=0;
    }

    public void add(T key){
        Node newNode = new Node(key);
        if(head == null) head = newNode;
        else  {
            tail.next = newNode;
            newNode.next = head;
        }           
        tail = newNode;
        size++;
    }

    public void remove(T key){
        Node p;
        int count = 0;
        for(p = head; count++<=size ; p=p.next){
            if(p.next.key.equals(key)){
                p.next = p.next.next;
                size--;
            }
        }
    }

    public Node search(T key) {
        int count = 0;
        for(Node p=head; count++<=size ; p=p.next)
            if(p.key.equals(key))
                return p;
        return null;
    }

    public Node at(int i) {
        for(Node p=head; p!=null; p=p.next, i--)
            if(i==0)
                return p;
        return null;
    }

    public void print(){
        if(head == null){
            System.out.println("Size:"+0);
            return;
        }
        int count = 0;
        for(Node p = head; count++<=size ; p=p.next)
            System.out.print(p.key+" -> ");
        System.out.println("null.   Size:"+size+"   Head: "+head.key+"  Tail: "+tail.key);
    }

}