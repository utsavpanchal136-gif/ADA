package ada;
import java.util.*;
public class bubble_sort {
   public static void main(String[] args) {
        // TODO code application logic here
        int i,j,temp,x;
        int a[]= new int [5];
        Scanner sc = new Scanner(System.in);
       for ( i=0;i<5;i++){
           a[i]=sc.nextInt();
       }
       long t1=System.nanoTime();
       for(i=0;i<5;i++){
           int f=0;
           for(j=i+1;j<5;j++){
               if(a[i]>a[j]){
                   f=1;
                   temp=a[i];
                   a[i]=a[j];
                   a[j]=temp;
               }
           }
            for ( x=0;x<5;x++){
           System.out.print(a[x]+" ");
            }
           if(f==0)
               break;
          
           
               System.out.println();
       
       }
       long t2=System.nanoTime();
       System.out.println("");
       System.out.println("after sorting");
       for ( i=0;i<5;i++){
           System.out.println(a[i]);
       }
       System.out.println("Time="+(t2-t1)+"ns");
    }
}

