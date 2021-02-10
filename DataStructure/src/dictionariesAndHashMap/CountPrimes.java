package dictionariesAndHashMap;

public class CountPrimes {
    public static void main(String[] args) {

    }

    public static int countPrimes(int n) {
        boolean[] primes = new boolean[n];
        for (int i = 2; i < n; i++) {
            primes[i] = true;
        }
        int count = 0;
        for (int i = 2; i*i < n; i++) {
            if (primes[i]) {
                for (int j = i*i; j < n; j += i) {
                    primes[j] = false;
                }
            }
        }
        for (int i = 2; i < n; i++) {
            if (primes[i])
                count++;
        }
        return count;
    }

}
