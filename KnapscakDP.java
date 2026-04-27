import java.util.Scanner;

public class KnapsackDP {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of items: ");
        int n = sc.nextInt();

        int[] weight = new int[n];
        int[] value = new int[n];

        System.out.println("Enter weights:");
        for (int i = 0; i < n; i++) {
            weight[i] = sc.nextInt();
        }

        System.out.println("Enter values:");
        for (int i = 0; i < n; i++) {
            value[i] = sc.nextInt();
        }

        System.out.print("Enter capacity: ");
        int W = sc.nextInt();

        int[][] dp = new int[n + 1][W + 1];

        // fill table
        for (int i = 0; i <= n; i++) {
            for (int w = 0; w <= W; w++) {

                if (i == 0 || w == 0) {
                    dp[i][w] = 0; // base case
                }

                else if (weight[i - 1] <= w) {
                    dp[i][w] = Math.max(
                        value[i - 1] + dp[i - 1][w - weight[i - 1]], // include
                        dp[i - 1][w] // exclude
                    );
                }

                else {
                    dp[i][w] = dp[i - 1][w]; // cannot include
                }
            }
        }

        // PRINT TABLE
        System.out.println("\nDP Table:");
        for (int i = 0; i <= n; i++) {
            for (int w = 0; w <= W; w++) {
                System.out.print(dp[i][w] + " ");
            }
            System.out.println();
        }

        System.out.println("\nMaximum value: " + dp[n][W]);

        sc.close();
    }
}

