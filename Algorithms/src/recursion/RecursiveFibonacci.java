package recursion;

import java.util.Scanner;

public class RecursiveFibonacci {

    public static int fibonacci(int n) {
        if (n <= 1) {
            return n;
        }
        int result = fibonacci(n-1) + fibonacci(n-2);
        return result;
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.close();
        System.out.println(fibonacci(n));
    }
}
