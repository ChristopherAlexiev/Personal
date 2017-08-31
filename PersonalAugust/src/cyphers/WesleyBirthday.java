package cyphers;

import java.util.Scanner;


public class WesleyBirthday {

	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);
		System.out.println("Hello, would you like to encrypt (1) or decrypt (2) this today?");

		String alphabet = " zyxwvutsrqponmlkjihgfedcba";
		//ADDED TEST COMMENT
		String input = keyboard.nextLine();

		System.out.println("Enter phrase:");
		String output = "";

		if (input.equals("1")) {
			input = keyboard.nextLine();
			String fixedInput = "";
			for (int i = input.length() - 1; i >= 0; i--) {
				fixedInput += input.substring(i, i + 1);
			}
			input = fixedInput;
			input = input.toLowerCase();
			for (int i = 0; i < input.length(); i++) {
				if (input.substring(i, i + 1).equals(" ")) {
					output += "|";
				} else if (i == input.length() - 1) {
					int number = alphabet.indexOf(input.charAt(i));
					output += Integer.toBinaryString(number);

				} else {
					int number = alphabet.indexOf(input.charAt(i));
					output += Integer.toBinaryString(number) + "|";

				}
			}
		} else if (input.equals("2")) {
			input = keyboard.nextLine();
			String[] parts = input.split("\\|");
			for (int i = 0; i < parts.length; i++) {
				if (parts[i].equals("")) {
					output += " ";
				} else {
					int powerExponent = 0;
					int letterNum = 0;
					for (int j = parts[i].length() - 1; j >= 0; j--) {
						letterNum += Math.pow(2, powerExponent) * Integer.parseInt(parts[i].substring(j, j + 1));
						powerExponent++;
					}
					output += alphabet.substring(letterNum, letterNum + 1);
				}
			}

			String fixedOutput = "";
			for (int i = output.length() - 1; i >= 0; i--) {
				fixedOutput += output.substring(i, i + 1);
			}
			output = fixedOutput;
		}
		System.out.println();
		System.out.println(output);

	}

}
