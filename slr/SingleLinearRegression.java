/**
 * @author Dylan Nguyen
 * Basic implementation of a single linear regression
 * Uses the least squares method to find the best fit line for a set of data
 * Uses formula that finds an intercept and slope that best minimizes the mean squared error
 */


import java.util.Scanner;

public class SingleLinearRegression {
	// base table of values
	// precondition: x and y must have the same length
	private static double[] x, y;

	// values for calculation
	private static double xMean, yMean, // x and y means
			mse, // mean squared error; goal is to minimize
			b0, b1; // y int and slope of the regression, respectively

	// calculate mean square error
	// assumes that b0 and b1 are existing values /= 0
	public static double getMSE() {
		double sum = 0;
		for (int i = 0; i < x.length; i++) {
			double yi = b0 + b1 * x[i]; // predicted y value
			sum += Math.pow(y[i] - yi, 2); // y[i] - yi is the residual/error, squared and summed for mse
		}
		return sum / x.length; // average of the squared residuals/errors
	}

	// calculates theta1, or the slope in a single linear regression
	public static double getB1() {
		double nom = 0;
		for (int i = 0; i < x.length; i++) {
			nom += (x[i] - xMean) * (y[i] - yMean);
		}
		double denom = 0;
		for (int i = 0; i < x.length; i++) {
			denom += Math.pow(x[i] - xMean, 2);
		}
		return nom / denom;
	}

	// calculates theta0, or the y intercept in a single linear regression
	public static double getB0() {
		return yMean - (getB1() * xMean); // y = b0 + b1x, so b0 = y - b1 * x
	}


	public static double getXMean() {
		double sum = 0;
		for (int i = 0; i < x.length; i++) {
			sum += x[i];
		}
		return sum / x.length;
	}

	public static double getYMean() {
		double sum = 0;
		for (int i = 0; i < y.length; i++) {
			sum += y[i];
		}
		return sum / y.length;
	}

	public static void main(String[] args) {
		x = new double[10];
		double xt = 0;
		y = new double[10];
		double yt = 0;
		for (int i = 0; i < 10; i++) {
			x[i] = xt;
			y[i] = yt;
			xt += Math.random() * 5;
			yt += Math.random() * 5;
		}

		System.out.println("TABLE");
		for (int i = 0; i < 10; i++) {
			System.out.println(x[i] + " " + y[i]);
		}

		xMean = getXMean();
		yMean = getYMean();
		b1 = getB1();
		b0 = getB0();
		mse = getMSE();
		System.out.println();
		System.out.println("b0: " + b0);
		System.out.println("b1: " + b1);
		System.out.println("mse/r^2: " + mse);
		System.out.println();
		System.out.println("y = " + b0 + " + " + b1 + "x");
		System.out.println();
		Scanner scann = new Scanner(System.in);
		String input = "";
		while (!input.equals("exit")) {
			System.out.println("Enter a value for x to predict y, or type 'exit' to quit");
			input = scann.nextLine();
			if (input.equals("exit")) {
				break;
			}
			double x = Double.parseDouble(input);
			double y = b0 + b1 * x;
			System.out.println("Predicted y: " + y);
		}
		scann.close();
	}
}