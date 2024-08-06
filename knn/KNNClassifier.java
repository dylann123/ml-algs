/**
 * @author Dylan Nguyen
 * Basic implementation of a K-Nearest Neighbors, or KNN, classifier
 * Uses Euclidean distance to calculate the distance between two points on an n-dimensional plane
 */
package knn;

import java.util.HashMap;

public class KNNClassifier {

	// prerequisites: iv.length == dv.length
	// iv[i].length == iv[0].length for all i
	public int[][] iv;
	public int[] dv;

	// iv is the input vectors/features, dv is the corresponding output vectors, or classifications
	public KNNClassifier(int[][] iv, int[] dv) {
		this.iv = iv;
		this.dv = dv;
	}

	// k is the number of neighbors to consider
	// input is the input vector, or row, to classify
	// returns the classification of the input vector based on the k-nearest neighbors
	public int classify(int[] input, int k) {
		if (k < 1)
			throw new IllegalArgumentException("k must be greater than 0");
		if (input.length != iv[0].length)
			throw new IllegalArgumentException("input length must be equal to the length of the input vectors");
		if (k > iv.length)
			throw new IllegalArgumentException("k must be less than or equal to feature vector length");
		
		
		// get distance of all neighbors on an iv.length-dimensional plane
		double[] distances = new double[iv.length];
		for (int row = 0; row < iv.length; row++) {
			int tsd = 0; // total squared difference of each neighbor
			for (int col = 0; col < iv[row].length; col++) {
				tsd += Math.pow(iv[row][col] - input[col], 2);
			}
			distances[row] = tsd;
		}

		// copy dv to dvop to sort dvop without affecting dv
		int[] dvop = dv.clone();

		// sort distances via selection sort
		// also sorts the DV to match the distances for mode calculation
		for (int i = 0; i < distances.length; i++) {
			int minIndex = i;
			for (int j = i + 1; j < distances.length; j++)
				if (distances[j] < distances[minIndex])
					minIndex = j;
					
			double temp = distances[i];
			distances[i] = distances[minIndex];
			distances[minIndex] = temp;

			int temp2 = dvop[i];
			dvop[i] = dvop[minIndex];
			dvop[minIndex] = temp2;
		}

		// find mode of k-nearest neighbors
		HashMap<Integer, Integer> mode = new HashMap<>();
		for (int i = 0; i < k; i++) {
			int key = dvop[i];
			if (mode.containsKey(key))
				mode.put(key, mode.get(key) + 1);
			else
				mode.put(key, 1);
		}

		// find the key with the highest value
		int max = 0;
		int maxKey = 0;
		for (int key : mode.keySet()) {
			if (mode.get(key) > max) {
				max = mode.get(key);
				maxKey = key;
			}
		}

		return maxKey;
	}
}