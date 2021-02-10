package stacks;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class BalancedBrackets {

	// Complete the isBalanced function below.
	static String isBalanced(String s) {
		Stack<Character> stack = new Stack<Character>();
		int len = s.length();
		for (int i = 0; i < len; i++) {
			char c = s.charAt(i);
			switch (c) {
				case '}':
					if (stack.isEmpty() || stack.pop() != '{') {
						return "NO";
					}
					break;

				case ']':
					if (stack.isEmpty() || stack.pop() != '[') {
						return "NO";
					}
					break;

				case ')':
					if (stack.isEmpty() || stack.pop() != '(') {
						return "NO";
					}
					break;

				default:
					stack.push(c);
					break;
			}
		}
		if (stack.isEmpty()) {
			return "YES";
		} else {
			return "NO";
		}



	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws IOException {

		int mask = 0x000F;
		int value = 0x2222;
		System.out.println(mask&value);

		// /* asd // // sfsd*/

		BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

		int t = scanner.nextInt();
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		for (int tItr = 0; tItr < t; tItr++) {
			String s = scanner.nextLine();

			String result = isBalanced(s);

			bufferedWriter.write(result);
			bufferedWriter.newLine();
		}

		bufferedWriter.close();

		scanner.close();
	}
}

