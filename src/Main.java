package src;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		List<Integer> missingNumbers = findMissingNumbers();
		Collections.sort(missingNumbers);
		System.out.println("Missing numbers: " + missingNumbers + "\n");

		String binary = decimalToBinary(568);
		System.out.println("Decimal to binary convert: " + binary + "\n");

		String hexColor = hexCode();
		System.out.println("Hex color code: " + hexColor + "\n");

		int matrixSum = sumOfMatrix();
		System.out.println("Sum of matrix: " + matrixSum + "\n");

		int maxNumberOfMatrixDiagonal = findMaxNumberFromMatrixDiagonals();
		System.out.println("Maximum number of matrix diagonals: " + maxNumberOfMatrixDiagonal + "\n");

		int root = findRoot();
		System.out.println("Root of square: " + root + "\n");

		boolean primeNumber = isPrime(9);
		System.out.println("Prime number: " + primeNumber);
	}

	public static boolean isPrime(int num) {
		for (int i = 2; i < num / 2; i++) {
			if (num % i == 0) {
				return false;
			}
		}
		return true;
	}

	public static int findRoot() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter a number: ");
		int number = scanner.nextInt();
		for (int i = 1; i < number; i++) {
			if ((i * i) == number) {
				return i;
			}
			scanner.close();
		}
		return 0;
	}

	public static String hexCode() {
		Random random = new Random();
		String letters = "0123456789ABCDEF";
		String hex = "#";
		for (int i = 0; i < 6; i++) {
			int randomNumber = (int) Math.floor(random.nextDouble(letters.length()));
			hex += letters.charAt(randomNumber);
		}
		return hex;
	}

	public static String decimalToBinary(int input) {
		if (input == 0) {
			return "0";
		}
		String binary = "";
		while (input > 0) {
			binary = (input % 2) + binary;
			input = input / 2;
		}
		return binary;
	}

	public static int findMaxNumberFromMatrixDiagonals() {
		int[][] arr = { { 1, 5, 1, 10 }, { 0, 1, 0, 6 }, { 6, 1, 0, 5 }, { 0, 3, 2, 4 } };
		int max = arr[0][0];
		for (int i = 0; i < arr.length; i++) {
			if (arr[i][i] > max) {
				max = arr[i][i];
			}
			if (arr[i][arr.length - 1 - i] > max) {
				max = arr[i][arr.length - 1 - i];
			}
		}
		return max;
	}

	public static List<Integer> findMissingNumbers() {
		List<Integer> arr = new ArrayList<Integer>(Arrays.asList(2, 4, 1, 9));
		int max = arr.get(0);
		int min = arr.get(0);

		for (int i = 0; i < arr.size(); i++) {
			if (arr.get(i) > max)
				max = arr.get(i);
			if (arr.get(i) < min)
				min = arr.get(i);
		}

		for (int i = min; i <= max; i++) {
			for (int j = 0; j < arr.size(); j++) {
				if (!arr.contains(i)) {
					arr.add(i);
				}
			}
		}
		return arr;
	}

	public static int sumOfMatrix() {
		int sum = 0;
		int[][] arr = { { 1, 5, 1, 0 }, { 0, 1, 0, 6 }, { 6, 1, 0, 5 }, { 0, 3, 2, 4 } };
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				if (arr[i][j] == 0) {
					if (i + 1 < arr.length) {
						arr[i + 1][j] = 0;
					}
				} else {
					sum += arr[i][j];
				}
			}
		}
		return sum;
	}

	public static String decimalToBinary(double input) {
		if (input == 0)
			return "0";

		String binary = "";

		while (input > 0) {
			binary = (input % 2) + binary;
			input = (int) Math.floor(input / 2);
		}
		return binary;
	}

}