/**
 * @author Dylan Nguyen
 */
package knn;

public class KNNDriver {
	public static void main(String[] args) {
		/*
		 * Table appears as
		 * x1 x2 x3 x4 x5 y
		 * 23 76 12 45 88 3
		 * 35 98 57 66 21 1
		 * ...
		 */
		int[][] iv = {
				{ 23, 76, 12, 45, 88 },
				{ 35, 98, 57, 66, 21 },
				{ 64, 21, 88, 49, 73 },
				{ 45, 53, 32, 90, 19 },
				{ 78, 1, 67, 85, 33 },
				{ 5, 91, 39, 17, 61 },
				{ 42, 11, 55, 74, 28 },
				{ 99, 27, 60, 92, 14 },
				{ 84, 31, 2, 46, 59 },
				{ 13, 79, 40, 72, 18 },
				{ 29, 65, 34, 77, 25 },
				{ 58, 93, 48, 10, 70 },
				{ 37, 62, 91, 50, 30 },
				{ 6, 81, 22, 63, 98 },
				{ 79, 14, 83, 47, 16 },
				{ 56, 8, 75, 20, 54 },
				{ 27, 68, 41, 86, 9 },
				{ 31, 92, 7, 52, 71 },
				{ 48, 35, 61, 3, 26 },
				{ 60, 19, 81, 87, 43 },
				{ 70, 5, 22, 78, 64 },
				{ 25, 83, 17, 93, 55 },
				{ 90, 11, 33, 40, 62 },
				{ 39, 18, 72, 95, 4 },
				{ 14, 67, 45, 82, 20 },
				{ 76, 54, 29, 13, 69 },
				{ 47, 59, 6, 98, 32 },
				{ 28, 77, 63, 8, 44 },
				{ 53, 36, 97, 71, 24 },
				{ 50, 7, 79, 41, 68 }
		};
		int[] dv = { 3, 1, 4, 2, 1, 3, 4, 2, 3, 1, 2, 4, 3, 1, 2, 3, 4, 1, 2, 3, 4, 1, 2, 3, 4, 1, 2, 3, 4, 1 };
		KNNClassifier knn = new KNNClassifier(iv, dv);
		int[] input = {
				(int) Math.floor(Math.random() * 99),
				(int) Math.floor(Math.random() * 99),
				(int) Math.floor(Math.random() * 99),
				(int) Math.floor(Math.random() * 99),
				(int) Math.floor(Math.random() * 99) };

		System.out.println(
				"Predicting y of " + input[0] + " " + input[1] + " " + input[2] + " " + input[3] + " " + input[4]);

		System.out.println(knn.classify(input, 3));
	}
}
