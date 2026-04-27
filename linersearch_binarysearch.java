package ada;
import java.util.*;

public class linersearch_binarysearch {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int arr[] = {10,20,30,40,50,60,70};

        System.out.print("Enter element to search: ");
        int key = sc.nextInt();

        // -------- LINEAR SEARCH --------
        int pos1 = -1;

        for(int i = 0; i < arr.length; i++) {

            // PASS OUTPUT: show each comparison
            System.out.println("Linear Search Step " + (i+1) + 
                               ": comparing " + key + " with " + arr[i]);

            if(arr[i] == key) {
                pos1 = i;
                break; // stop if found
            }
        }

        if(pos1 != -1)
            System.out.println("Linear Search: Found at position " + pos1);
        else
            System.out.println("Linear Search: Not Found");


        // -------- BINARY SEARCH --------
        int low = 0, high = arr.length - 1;
        int pos2 = -1;
        int step = 1;

        while(low <= high) {

            int mid = (low + high) / 2;

            // PASS OUTPUT: show current low, high, mid
            System.out.println("Binary Search Step " + step + 
                ": low=" + low + " high=" + high + 
                " mid=" + mid + " (value=" + arr[mid] + ")");

            if(arr[mid] == key) {
                pos2 = mid;
                break;
            } 
            else if(arr[mid] < key) {
                low = mid + 1; // search right half
            } 
            else {
                high = mid - 1; // search left half
            }

            step++;
        }

        if(pos2 != -1)
            System.out.println("Binary Search: Found at position " + pos2);
        else
            System.out.println("Binary Search: Not Found");

        sc.close();
    }
}

