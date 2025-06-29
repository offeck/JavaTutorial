public class insert {

    public static void main(String[] args) {
        int[] array = { 1, 2, 3, 5, 2 };
        int i = 4;
        insert(array, i);
        printArray(array); // { 1, 2, 3, 4, 5 }
    }
    // Helper function to print array
    public static void printArray(int[] array) {
        for (int num : array) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

    public static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
    
    public static void insert(int[] array, int i) {
        for (int j = i-1; j > 0; j=j-1) {
            if (array[j] > array[i]) {
                swap(array, i, j);
                i = i - 1;               
            }
        }
    }
}
