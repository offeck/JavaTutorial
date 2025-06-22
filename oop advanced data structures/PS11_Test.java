import java.util.Comparator;
import java.util.Iterator;

public class PS11_Test {
    public static void main(String[] args) {

        // Find Min and Contains
        System.out.println("\nUsage of contains in BST:");
        Comparator<Integer> cmprtr = new IntegerComparator();
        BinarySearchTree<Integer> bst = new BinarySearchTree<>(cmprtr);
        bst.insert(5);
        bst.insert(2);
        bst.insert(1);
        bst.insert(8);
        bst.insert(7);
        bst.insert(9);
        System.out.println("Minimum of BST = " + bst.findMin());
        System.out.println("BST contains 9 = " + bst.contains(9));
        System.out.println("BST contains -1 = " + bst.contains(-1));

        // BST Path Iterator
        System.out.println("\nUsage of path iterator in BST:");
        // (bst and cmprt from before)

        Iterator<Integer> it1 = bst.pathIterator(3);
        System.out.println("Path of 3");
        while (it1.hasNext())
            System.out.print(it1.next() + " ");
        System.out.println();

        System.out.println("Path of -1");
        Iterator<Integer> it2 = bst.pathIterator(-1);
        while (it2.hasNext())
            System.out.print(it2.next() + " ");
        System.out.println();

        System.out.println("Path of 9");
        Iterator<Integer> it3 = bst.pathIterator(9);
        while (it3.hasNext())
            System.out.print(it3.next() + " ");
        System.out.println();
    }
}
