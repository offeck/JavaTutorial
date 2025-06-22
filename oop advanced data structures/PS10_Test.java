import java.util.Arrays;

public class PS10_Test {

    public static void main(String[] args) {

        // Comparable - example:
        Integer i1 = 9;
        Integer i2 = 9;
        String s1 = "19";
        String s2 = "3";
        System.out.println(i1.compareTo(i2));
        System.out.println(s1.compareTo(s2));

        // Date - example:
        System.out.println("\nThe class Date - example:");
        Date date1 = new Date(9, 12, 1994);
        Date date2 = new Date(29, 11, 1997);
        Date date3 = new Date(3, 1, 2000);

        System.out.println(date1);  //9.12.1994
        System.out.println(date2);  //29.11.1997
        System.out.println(date3);  //3.1.2000

        // Compare Dates - sorting:
        System.out.println("\nDates:");
        Date[] dates_arr = {date1, date2, date3};      //[29.11.1997, 21.1.2000, 1.12.1994]

        System.out.println("dates_array before sorting:");
        System.out.println(Arrays.toString(dates_arr));   //[29.11.1997, 21.1.2000, 1.12.1994]

        SortAlgorithms.insertionSort(dates_arr);
        System.out.println("dates_array after sorting:");
        System.out.println(Arrays.toString(dates_arr));   //[1.12.1994, 29.11.1997, 21.1.2000]

        // Compare – using getMax:
        System.out.println("\nUsing getMax:");
//        Set<Integer> setA2 = new SetAsDynamicArray<>();
//        setA.add(1);
//        setA.add(5);
//        setA.add(2);             //setA = {1,5,2}

        Set<String> setB = new SetAsDynamicArray<>();
        setB.add("Shauli");
        setB.add("Hector");
        setB.add("Amatzia");    //setB = {“Shauli”, “Hector”, “Amatzia”}

        Set<Date> setC = new SetAsDynamicArray<>();
        setC.add(new Date(29, 11, 1997));
        setC.add(new Date(21, 1, 2000));
        setC.add(new Date(1, 12, 1994));     //setC = {29.11.1997, 21.1.2000, 1.12.1994}

//        System.out.println(SetOperations.getMax(setA)); //5
        System.out.println(SetOperations.getMax(setB)); //Shauli
        System.out.println(SetOperations.getMax(setC)); //21.1.2000

        // Compare sets by max value:
        System.out.println("\nSorting sets in an array by the maximum element:");
        Set<Integer> set152 = new SetAsDynamicArray<>();
        set152.add(1);
        set152.add(5);
        set152.add(2);

        Set<Integer> emptySet = new SetAsDynamicArray<>();

        Set<Integer> set7 = new SetAsDynamicArray<>();
        set7.add(7);

        Set<Integer> set345 = new SetAsDynamicArray<>();
        set345.add(3);
        set345.add(4);
        set345.add(5);

        Set<Integer>[] setsArray = new Set[4];
        setsArray[0] = set152;
        setsArray[1] = emptySet;
        setsArray[2] = set7;
        setsArray[3] = set345;

        System.out.println(Arrays.toString(setsArray));            //[{1, 5, 2}, {}, {7}, {3, 4, 5}]
        SortAlgorithms.insertionSort(setsArray, new SetMaxComparator<>());
        System.out.println(Arrays.toString(setsArray));            //[{}, {1, 5, 2}, {3, 4, 5}, {7}]

        // Binary  Tree
        BinaryTree<Integer> tree = new BinaryTree<Integer>();
        tree.insert(1);
        tree.insert(6);
        tree.insert(3);
        tree.insert(8);
        tree.insert(5);
        tree.insert(2);
        tree.insert(9);

        System.out.println("\nTree in order:");
        tree.printInOrder();

        tree.mirror();
        System.out.println("\nTree in order after mirroring:");
        tree.printInOrder();

    }


}
