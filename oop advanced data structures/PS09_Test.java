import java.util.Iterator;

public class PS09_Test {
    public static void main(String[] args) {

        // Iterators
        // Go ever the elements of an array
        System.out.println("\nIterate over array:");
        String[] strArray = new String[3];
        strArray[0]  = "hello";
        strArray[1]  = "world";
        strArray[2]  = "goodbye";
        int i = 0;
        while( i<strArray.length ) {
            System.out.println(strArray[i]);
            i = i + 1;
        }

        // Go over the elements of a list
        System.out.println("Iterate over list:");
        List<String> list = new LinkedList<String>();
        list.add("hello");
        list.add("world");
        list.add("goodbye");

        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            System.out.print(it.next() + " ");
        }

        // Generator
        System.out.println("\n\nFact Generator:");
        FactGenerator factIter = new FactGenerator(3);
        for(int j = 0; j < 3 & factIter.hasNext(); j = j + 1){
            System.out.println(factIter.next());
        }


        // Sets
        System.out.println("\nSets:");
        Set<Integer> setA = new SetAsDynamicArray<>();
        setA.add(1);
        setA.add(2);
        setA.add(3);

        System.out.println(SetOperations.powerSet(new SetAsDynamicArray<>()));  //Set: {Set: {}}
        System.out.println(SetOperations.powerSet(setA));     //Set: {Set: {2, 3, 1}, Set: {2, 1}, Set: {3, 1}, Set: {1}, Set: {2, 3}, Set: {2}, Set: {3}, Set: {}}

    }
}
