import java.util.Scanner;

public class CoinChangeDP {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of coin types: ");
        int n = sc.nextInt();

        System.out.print("Enter amount: ");
        int amount = sc.nextInt();

        int[] coins = new int[n];

        System.out.println("Enter coin denominations:");
        for (int i = 0; i < n; i++) {
            coins[i] = sc.nextInt();
        }

        int[][] dp = new int[n][amount + 1];

        // initialize first column
        for (int i = 0; i < n; i++) {
            dp[i][0] = 0;
        }

        // initialize first row
        for (int j = 1; j <= amount; j++) {
            if (j % coins[0] == 0)
                dp[0][j] = j / coins[0];
            else
                dp[0][j] = Integer.MAX_VALUE / 2; // avoid overflow
        }

        // fill table
        for (int i = 1; i < n; i++) {
            for (int j = 1; j <= amount; j++) {

                if (coins[i] <= j)
                    dp[i][j] = Math.min(dp[i - 1][j], 1 + dp[i][j - coins[i]]);
                else
                    dp[i][j] = dp[i - 1][j];
            }
        }

        // PRINT TABLE
        System.out.println("\nDP Table:");

        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= amount; j++) {

                if (dp[i][j] >= Integer.MAX_VALUE / 2)
                    System.out.print("∞ ");
                else
                    System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }

        System.out.println("\nMinimum coins required: " + dp[n - 1][amount]);

        sc.close();
    }
}
