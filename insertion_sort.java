package ada;
import java.util.*;

public class insertion_sort {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input number of elements
        System.out.print("Enter number of elements: ");
        int n = sc.nextInt();

        int arr[] = new int[n];

        // Input elements
        System.out.println("Enter elements:");
        for(int i = 0; i < n; i++)
            arr[i] = sc.nextInt();

        long start = System.nanoTime(); // Start time

        // Insertion Sort Logic
        for(int i = 1; i < n; i++) {

            int key = arr[i];   // Element to be inserted
            int j = i - 1;

            // Shift elements greater than key to one position ahead
            while(j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j--;
            }

            // Place key at correct position
            arr[j + 1] = key;

            // -------- PASS / STEP OUTPUT --------

            // Print current pass number
            System.out.print("Pass " + i + ": ");

            // Print array after each insertion
            for(int k = 0; k < n; k++) {
                System.out.print(arr[k] + " ");
            }

            // Move to next line
            System.out.println();

            // -----------------------------------
        }

        long end = System.nanoTime(); // End time

        // Print sorted array
        System.out.println("Sorted Array:");
        for(int x : arr)
            System.out.print(x + " ");

        // Print execution time
        System.out.println("\nExecution Time: " + (end - start) + " ns");

        sc.close();
    }
}
