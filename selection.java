package ada;
import java.util.*;

public class selection_sort {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input number of elements
        System.out.print("Enter number of elements: ");
        int n = sc.nextInt();

        int arr[] = new int[n];

        // Input array elements
        System.out.println("Enter elements:");
        for(int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        long start = System.nanoTime(); // Start time measurement

        // Selection Sort Logic
        for(int i = 0; i < n - 1; i++) {

            int min = i; // Assume current index as minimum

            // Find index of minimum element in remaining array
            for(int j = i + 1; j < n; j++) {
                if(arr[j] < arr[min]) {
                    min = j;
                }
            }

            // Swap the found minimum element with first element
            int temp = arr[i];
            arr[i] = arr[min];
            arr[min] = temp;

            // -------- PASS / STEP OUTPUT --------
            System.out.print("Pass " + (i + 1) + ": ");
            for(int k = 0; k < n; k++) {
                System.out.print(arr[k] + " ");
            }
            System.out.println();
            // -----------------------------------
        }

        long end = System.nanoTime(); // End time measurement

        // Print sorted array
        System.out.println("Sorted Array:");
        for(int x : arr) {
            System.out.print(x + " ");
        }

        // Print execution time
        System.out.println("\nExecution Time: " + (end - start) + " ns");
    }
}


