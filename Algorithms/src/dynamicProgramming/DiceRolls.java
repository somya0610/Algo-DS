package dynamicProgramming;

public class DiceRolls {
    public static void main(String[] args) {
        numRollsToTarget(2, 6, 7);
    }

    public static int numRollsToTarget(int d, int f, int target) {
        if (d == 0 && target == 0)
            return 1;
        if (d <= 1 && target > f)
            return 0;
        int mod = (int) (Math.pow(10, 9) + 7);
        int[][] numOfComb = new int[d+1][target+1];
        numOfComb[0][0] = 1;
        for (int i = 1; i <= d; i++) {
            for (int j = i; j <= target; j++) {
                if (j > i * f)
                    continue;
                for(int k = 1; k <= f && k <= j ; k++) {
                    numOfComb[i][j] = (numOfComb[i][j] + numOfComb[i - 1][j - k]) % mod;
                }
            }
        }
        return numOfComb[d][target];
    }
}
