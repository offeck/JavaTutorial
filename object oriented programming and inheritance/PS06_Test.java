public class PS06_Test {

    public static void main(String[] args) {
        // ex.1
        System.out.println("Exercise 1: Student");
        Student student1 = new Student("Irena Israeli", "456789123", 99.9, 3);
        Student student2 = new Student("Israel Cohen", "30123456");
        System.out.println("Student is " + student2.toString());
        System.out.println("Number of days in reserve is " + student2.getDaysInReserve());
        student2.addDaysInReserve(70);
        student2.setAvgGrade(85);
        student2.addDaysInReserve(2);
        System.out.println("Number of days in reserve after updating is " + student2.getDaysInReserve());
        System.out.println();

        // ex.2
        System.out.println("Exercise 2: Ordered Pair");
        OrderedPair<String, Integer> pair4 = new OrderedPair<String, Integer>("Avi", 1);
        OrderedPair<String, Integer> pair5 = new OrderedPair<>("Avi", 1);
        System.out.println("Name and number of pair4 is: " + pair4);
        System.out.println("Name and number of pair5 is: " + pair5);
        System.out.println("Comparison between pairs with == returns " + (pair4 == pair5));
        System.out.println("Comparison between pairs with equals returns " + pair4.equals(pair5));

    }


}