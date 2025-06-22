
public class SubsetSum {
	
	// Assume weights is not null, sum >= 0
	// Returns true iff any subset of weights sum to sum.
	public static boolean subsetSum(int[] weights, int sum){
		return subsetSum(weights, sum, 0);
	}

	// Assume weights is not null, sum >= 0, 0 <= i < weights.length
	// Returns true iff any subset of weights sum to sum, starting at index i.
	public static boolean subsetSum(int[] weights, int sum, int i){
		boolean ans;
		if(sum == 0)
			ans = true;
		else if(sum < 0 || i >= weights.length)
			ans = false;
		else 
			ans = subsetSum(weights, sum - weights[i], i + 1) || subsetSum(weights, sum, i + 1);
		return ans;
	}

	// Assume weights is not null, sum >= 0
	// Returns the number of subsets of weights which sum to sum.
	public static int countSsubsetSum(int[] weights, int sum){
		return countSsubsetSum(weights, sum, 0);
	}

	// Assume weights is not null, sum >= 0, 0 <= i < weights.length
	// Returns the number of subsets of weights which sum to sum, starting at index i.
	public static int countSsubsetSum(int[] weights, int sum, int i){
		int ans = 0;
		if(sum == 0)
			ans = 1;
		else if(sum < 0 || i >= weights.length)
			ans = 0;
		else
			ans = countSsubsetSum(weights, sum - weights[i], i + 1) + countSsubsetSum(weights, sum, i + 1);
		return ans;
	}

}