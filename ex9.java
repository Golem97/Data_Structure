
/******************************************************************************
*  @author Nathanael Benichou
*  https://github.com/Golem97
*  Data Structures 2020 - CS Ariel university
*  Exercise 9 - Binary Trees 
******************************************************************************/
public class ex9 {
    public static void main(String[] args) {

    /* Testing question 2,3: */
        BinaryTree<Integer> bt = new BinaryTree<>();
        bt.add(1);
        bt.add(2);
        bt.add(3);
        bt.add(4);
        bt.add(5);
        bt.printInorder();
        bt.printPostorder();
        bt.printPreorder();
        bt.printBinaryTree();
    /* Testing question 4: */
        System.out.println("Size: "+bt.size());
    /* Testing question 5: */
        System.out.println(bt.find(4));
    /* Testing question 6: */
        System.out.println(bt.isLeaf(7));
    }

//_____________________________________________________________________________
    //Question 1: 
    /*
    -----Tree 1----- 
    preorder:  3,1,14,5,4,7,16,15,20
    inorder:   1,3,4,5,7,14,15,16,20
    postorder: 1,4,7,5,15,20,16,14,3
    -----Tree 2----- 
    preorder:  F,B,A,D,C,E,G,I,H
    inorder:   A,B,C,D,E,F,G,H,I
    postorder: A,C,E,D,B,H,I,G,F
    -----Tree 3----- 
    preorder:  D,B,A,C,F,E,G
    inorder:   A,B,C,D,E,F,G
    postorder: A,C,B,E,G,F,D

    */
    

}