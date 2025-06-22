
public class CumulativeSum {

    public static void main(String[] args) {
        int[] a = {1, 2, 4, 8};
        accumulate(a);
    }

    //assume myArray is not null
    //changes the array so each index has the current sum from the start of the array
    public static void accumulate(int[] myArray) {
        int currentSum = 0;
        for(int i = 0; i < myArray.length; i = i + 1) {
            currentSum = currentSum + myArray[i]; // add current index the total so far
            myArray[i] = currentSum; // update *the original* array
        }
        return;
    }
}
