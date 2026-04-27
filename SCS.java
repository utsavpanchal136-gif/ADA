import java.util.Scanner;

public class SCS {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter first string: ");
        String X = sc.nextLine();

        System.out.print("Enter second string: ");
        String Y = sc.nextLine();

        int m = X.length();
        int n = Y.length();

        int[][] dp = new int[m + 1][n + 1];

        // Step 1: Build LCS table
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {

                if (X.charAt(i - 1) == Y.charAt(j - 1))
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                else
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
            }
        }

        // PRINT TABLE
        System.out.println("\nDP Table (LCS):");
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }

        // Step 2: Build SCS from table
        int i = m, j = n;
        String scs = "";

        while (i > 0 && j > 0) {

            if (X.charAt(i - 1) == Y.charAt(j - 1)) {
                scs = X.charAt(i - 1) + scs;
                i--;
                j--;
            }

            else if (dp[i - 1][j] > dp[i][j - 1]) {
                scs = X.charAt(i - 1) + scs;
                i--;
            }

            else {
                scs = Y.charAt(j - 1) + scs;
                j--;
            }
        }

        // add remaining characters
        while (i > 0) {
            scs = X.charAt(i - 1) + scs;
            i--;
        }

        while (j > 0) {
            scs = Y.charAt(j - 1) + scs;
            j--;
        }

        System.out.println("\nSCS: " + scs);
        System.out.println("Length of SCS: " + scs.length());

        sc.close();
    }
}


