
/******************************************************************************
*  @author Nathanael Benichou
*  https://github.com/Golem97
*  Data Structures 2020 - CS Ariel university
*  Exercise 9 - Binary trees 
******************************************************************************/
public class BinaryTree<T> {
    private static class Node<T>{
        private T key;
        private Node<T> right, left;

        public Node(T val){
            key = val;
            right = left = null;
        }
        public String toString(){
            return ""+key;
        }
    }

    private Node<T> root;
    
    public BinaryTree(){
        root = null;
    }

    public void add(T val){
        Node<T> newNode = new Node<>(val);
        if(root==null){
            root = newNode;
            return;
        }
        Node<T> p = root;
        while(p.left!=null && p.right!=null){
            double r = Math.random();
            if(r>= 0.5) p = p.right;
            if(r < 0.5) p = p.left;
        }
        if(p.left==null)  p.left = newNode;
        else if (p.right==null) p.right = newNode;
    }

    //Question 2:
    public void printInorder(){
        System.out.print("\nInOrder: ");
        printInorder(root);
    }
    private void printInorder(Node<T> p) {
        if(p==null) return;
        printInorder(p.left);
        System.out.print(p.key+", ");
        printInorder(p.right);
    }

    //Question 3:
    public void printPostorder(){
        System.out.print("\nPostOrder: ");
        printPostorder(root);
    }
    private void printPostorder(Node<T> p) {
        if(p==null) return;
        printPostorder(p.left);
        printPostorder(p.right);
        System.out.print(p.key+", ");
    }

    public void printPreorder(){
        System.out.print("\nPreorder: ");
        printPreorder(root);
    }
    private void printPreorder(Node<T> p) {
        if(p==null) return;
        System.out.print(p.key+", ");
        printPreorder(p.left);
        printPreorder(p.right);
    }

    //Question 4: 
    public int size(){
        return size(root);
    }
    private int size(Node<T> p) {
        if(p==null) return 0;
        return 1+size(p.right)+size(p.left);
    }

    //Question 5:
    public Node<T> find(Object data){
        return find(data,root);
    }
    private Node<T> find(Object data, Node<T> p) {
        if(p==null) return null;
        if(p.key.equals(data)) return p;
        Node<T> r = find(data, p.right);
        Node<T> l = find(data, p.left);
        if(r!=null) return r;
        if(l!=null) return l;
        return null;
    }

    //Question 6:
    public String isLeaf(Object data){
        Node<T> temp = find(data);
        if(temp == null) return "Not a vertex";
        if(temp.right == null && temp.left == null) return "a leaf";
        else return "Not a leaf";
    }

    // _____________________________________________________________________________
	/* Printing the tree visualy */
	public void printBinaryTree(){
        System.out.println();
		System.out.println("================================");
		printBinaryTree(root, 0);
		System.out.println("================================");
	}
	public void printBinaryTree(Node<T> root, int level){
		if(root==null)
			 return;
		printBinaryTree(root.right, level+1);
		if(level!=0){
			for(int i=0;i<level-1;i++)
				System.out.print("|\t");
				System.out.println("|-------"+root.key);
		}
		else
			System.out.println(root.key);
		printBinaryTree(root.left, level+1);
	}
}