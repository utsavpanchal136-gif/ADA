import java.util.Scanner;

public class MCM {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of matrices: ");
        int n = sc.nextInt();

        int[] p = new int[n + 1];

        System.out.println("Enter dimensions array:");
        for (int i = 0; i <= n; i++) {
            p[i] = sc.nextInt();
        }

        int[][] m = new int[n + 1][n + 1];
        int[][] s = new int[n + 1][n + 1];

        // chain length
        for (int L = 2; L <= n; L++) {

            for (int i = 1; i <= n - L + 1; i++) {

                int j = i + L - 1;
                m[i][j] = Integer.MAX_VALUE;

                for (int k = i; k < j; k++) {

                    int cost = m[i][k] + m[k + 1][j]
                            + p[i - 1] * p[k] * p[j];

                    if (cost < m[i][j]) {
                        m[i][j] = cost;
                        s[i][j] = k;
                    }
                }
            }
        }

        // PRINT M TABLE
        System.out.println("\nM Table (Cost):");
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (j < i)
                    System.out.print("  ");
                else
                    System.out.print(m[i][j] + " ");
            }
            System.out.println();
        }

        // PRINT S TABLE
        System.out.println("\nS Table (Split):");
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (j <= i)
                    System.out.print("  ");
                else
                    System.out.print(s[i][j] + " ");
            }
            System.out.println();
        }

        System.out.println("\nMinimum Cost: " + m[1][n]);

        sc.close();
    }
}
