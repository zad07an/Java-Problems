package src;

import java.util.Scanner;
// import java.lang.Math;
// import java.util.ArrayList;

public class Guess {
	public static void main(String args[]) {
		guessGame();
	}

	public static void guessGame() {
		int secretNumber = 69;
		int chance = 3;
		int round = 0;
		Scanner scanner = new Scanner(System.in);
		do {
			System.out.println("Enter a number between 1 to 100: ");
			int number = scanner.nextInt();
			if (number != secretNumber) {
				round++;
			} else {
				System.out.println("You won!\nThe secret number is " + secretNumber);
				break;
			}
		} while (round != chance);
		if (chance == round) {
			System.out.println("You lose :(");
		}
		scanner.close();
	}
}
