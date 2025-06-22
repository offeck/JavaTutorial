
public class CopyArray {

	public static void main(String[] args) {
		int[][] a = {{8, 4}, {11}, {}, null};
		int[][] b = copyArray(a);
	}

	// Assume a is not null (no assumptions on the inner arrays)
	// Deep copys the values of array a (including the inner array values) into new array b and returns new array
	public static int[][] copyArray(int[][] a) {
		int[][] copy = new int[a.length][];
		// what are the default values in copy?
		for(int i = 0; i < a.length; i = i + 1) {
			if(a[i] != null){
				copy[i] = new int[a[i].length];
				for(int j = 0; j < a[i].length; j = j + 1) {
					copy[i][j] = a[i][j];
				}
			}
		}
		return copy;
	}
}
