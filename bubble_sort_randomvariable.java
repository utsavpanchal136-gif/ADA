package ada;

import java.util.*;

public class bubble_sort_randomvariable {
    public static void main(String[] args) {

        int i, j, temp;
        int a[] = new int[5];

       
        for (i = 0; i < 5; i++) {
            a[i] = (int) (Math.random() * 100);
        }

        
        System.out.println("Before sorting:");
        printArray(a);

        
        long t1 = System.nanoTime();

       
        for (i = 0; i < 5; i++) {
            int f = 0; 

            System.out.println("\nPASS " + (i + 1) + ":");

            
            for (j = i + 1; j < 5; j++) {

                System.out.print("  Step (" + i + "," + j + "): ");

          
                if (a[i] > a[j]) {
                    f = 1; 
                    temp = a[i];
                    a[i] = a[j];
                    a[j] = temp;
                    System.out.print("Swap → ");
                } else {
                    System.out.print("No Swap → ");
                }

             
                printArray(a);
            }

           
            if (f == 0) {
                System.out.println("  No swaps in this pass → Array already sorted");
                break; 
            }
        }

      
        long t2 = System.nanoTime();

        
        System.out.println("\nAfter sorting:");
        printArray(a);

       
        System.out.println("\nTime = " + (t2 - t1) + " ns");
    }

   
    static void printArray(int[] a) {
        for (int x : a) {
            System.out.print(x + " ");
        }
        System.out.println();
    }
}
