package ada;
import java.util.*;

public class quick_sort {

    // Partition function: places pivot at correct position
    static int partition(int arr[], int low, int high) {
        int pivot = arr[high]; // Choose last element as pivot
        int i = low - 1;       // Index of smaller element

        // Traverse and rearrange elements
        for(int j = low; j < high; j++) {
            if(arr[j] < pivot) {
                i++;

                // Swap arr[i] and arr[j]
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        // Place pivot at correct position
        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;

        return i + 1; // Return partition index
    }

    static void quickSort(int arr[], int low, int high) {
        if(low < high) {

            // Partition index
            int pi = partition(arr, low, high);

            // -------- PASS / STEP OUTPUT --------

            // Print array after each partition step
            System.out.print("Pivot placed at index " + pi + ": ");
            for(int k = 0; k < arr.length; k++) {
                System.out.print(arr[k] + " ");
            }
            System.out.println();

            // -----------------------------------

            // Recursively sort left subarray
            quickSort(arr, low, pi - 1);

            // Recursively sort right subarray
            quickSort(arr, pi + 1, high);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input size
        System.out.print("Enter number of elements: ");
        int n = sc.nextInt();

        int arr[] = new int[n];

        // Input elements
        System.out.println("Enter elements:");
        for(int i = 0; i < n; i++)
            arr[i] = sc.nextInt();

        long start = System.nanoTime(); // Start time

        quickSort(arr, 0, n - 1); // Call quick sort

        long end = System.nanoTime(); // End time

        // Print sorted array
        System.out.println("Sorted Array:");
        for(int x : arr)
            System.out.print(x + " ");

        // Execution time
        System.out.println("\nExecution Time: " + (end - start) + " ns");

        sc.close();
    }
}
