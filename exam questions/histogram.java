public class histogram {
    public static int[] createSortedGrades(int[] histogram, int numOfGrades) {
        int[] grades;
        grades = new int[numOfGrades];
        int i = 0;
        for (int j = 0; j < histogram.length; j++) {
            int k = histogram[j];
            while (k != 0) {
                grades[i] = j;
                k = k - 1;
                i = i + 1;
            }
        }
        return grades;
    }

    // Helper function to print array
    public static void printArray(int[] array) {
        for (int num : array) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] histogram = { 3, 2, 0, 1, 4, 2, 1, 1, 1, 1, 2 };
        System.out.println(histogram.length);
        int numOfGrades = 18;
        printArray(createSortedGrades(histogram, numOfGrades));
    }
}
