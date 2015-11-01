import java.util.*;

class BubbleSort<T> extends ArraySort<T> {
   //boolean ascend;
   Comparator<T> myComp;
   //IntegerComparator myComp = new IntegerComparator(ascend);
   //Comparator<Integer> myComp = new IntegerComparator(ascend);
   public void iSort(T[] inArray) {
      //Comparator<T> myComp = new IntegerComparator(ascend);

      //IntegerComparator myComp = new IntegerComparator(ascend);
      //setComparator(myComp);
      //System.out.println(myComp.compare(1,2));

      // if array length < 10, print unsorted array
      if (inArray.length < 10) {
         for (int p=0;p<inArray.length;p++) {
            System.out.print(inArray[p] + " ");
         }

      }
      System.out.println(); // newline


      // Bubblesort algo
      T temp;
      for (int i=0;i<inArray.length;i++) {
         for (int j=0;j<inArray.length;j++) {
            if (myComp.compare(inArray[i],inArray[j]) == -1) {
               //System.out.println("Hi");
               temp = inArray[j];
               inArray[j] = inArray[i];
               inArray[i] = temp;
            }
         }
      }
      //System.out.println("Sort complete. Printing :");

      // if array length < 10, print sorted array
      /*if (inArray.length < 10) {
         for (int p=0;p<inArray.length;p++) {
            System.out.print(inArray[p] + " ");
         }

      }*/


   }
   /*public BubbleSort(boolean ascend) {
      this.ascend = ascend;
   }*/
   public T[] oSort(T[] inArray) {

      T temp;
      T[] newArray = inArray;
      for (int i=0;i<newArray.length;i++) {
         for (int j=0;j<newArray.length;j++) {
            if (myComp.compare(newArray[i],newArray[j]) == -1) {
               //System.out.println("Hi");
               temp = newArray[j];
               newArray[j] = newArray[i];
               newArray[i] = temp;
            }
         }
      }

      return newArray; // Placeholder

   }
   public void setComparator(Comparator<T> comparator) {
      //System.out.println("Calling setComparator ");

      //myComp = new IntegerComparator(ascend);
      myComp = comparator;

   }
   public long iSortTimed(T[] inArray) {
      long startTime = System.nanoTime();

      T temp;
      for (int i=0;i<inArray.length;i++) {
         for (int j=0;j<inArray.length;j++) {
            if (myComp.compare(inArray[i],inArray[j]) == -1) {
               //System.out.println("Hi");
               temp = inArray[j];
               inArray[j] = inArray[i];
               inArray[i] = temp;
            }
         }
      }


      long elapsedTime = System.nanoTime() - startTime;
      //elapsedTime = (double)elapsedTime / 1000000000.0;
      return elapsedTime;
   }

}

class MergeSort<T> extends ArraySort<T> {
   Comparator<T> myComp;

   private void mergeSort(T[] inArray, int p, int r) {
      if (p < r) {
         //System.out.println("p < r ");
         int q = (p+r)/2;
         mergeSort(inArray, p, q);
         mergeSort(inArray, q+1, r);
         //System.out.println("Doing merge: ");
         merge(inArray, p, q, r);
      }
   }
   private void merge(T[] inArray, int p, int q, int r) {
      T[] lowHalf = Arrays.copyOfRange(inArray, p, q+1);
      T[] highHalf = Arrays.copyOfRange(inArray, q+1, r+1);
      //System.out.println("inArray.length  = " + inArray.length);
      // Test block
      //for (int b = 0; b < lowHalf.length; b++) System.out.println("lowHalf: " + lowHalf[b]);
      //for (int z = 0; z < highHalf.length; z++) System.out.println("highHalf: " + highHalf[z]);

      int k = p;
      int i = 0;
      int j = 0;
      while (i < lowHalf.length && j < highHalf.length) {
         if (myComp.compare(lowHalf[i], highHalf[j]) == -1) {
            inArray[k] = lowHalf[i];
            i++;
            k++;
         }
         else {
            inArray[k] = highHalf[j];
            j++;
            k++;
         }
      }

      while (i < lowHalf.length) {
         inArray[k] = lowHalf[i];
         i++;
         k++;
      }
      while (j < highHalf.length) {
         inArray[k] = highHalf[j];
         j++;
         k++;
      }



   }

   public void setComparator(Comparator<T> comparator) {
      myComp = comparator;
   }





   public void iSort(T[] inArray) {
      // if array length < 10, print unsorted array
      //T[] mergedArray;
      if (inArray.length < 10) {
         for (int p=0;p<inArray.length;p++) {
            System.out.print(inArray[p] + " ");
         }

      }
      System.out.println(); // newline
      mergeSort(inArray, 0, inArray.length-1);
      // Print the sorted array
      //System.out.println("Sorted array: ");
      /*for (int y=0;y<inArray.length;y++) {
         System.out.print(inArray[y] + " ");
      }*/



   }
   public T[] oSort(T[] inArray) {
      T[] arrayCopy = inArray;
      mergeSort(arrayCopy, 0, inArray.length-1);
      return arrayCopy;
   }
   public long iSortTimed(T[] inArray) {
      long startTime = System.nanoTime();
      mergeSort(inArray, 0, inArray.length-1);
      long elapsedTime = System.nanoTime() - startTime;
      return elapsedTime;

   }
}

class QuickSort<T> extends ArraySort<T> {
   Comparator<T> myComp;

   private void qsort(T[] inArray, int p, int r) {

      if (p < r) {
         int pivot = partition(inArray, p, r);
         //System.out.println("Pivot = " + pivot);
         qsort(inArray, p, pivot-1);
         qsort(inArray, pivot+1, r);
      }
   }
   private int partition(T[] inArray, int p, int r) {

      int q = p;
      T temp;


      for (int j=p;j < r;j++) {
         //System.out.println("j: inArray[" + j + "] = " + inArray[j]);
         //System.out.println("q: inArray[" + q + "] = " + inArray[q]);
         //System.out.println("Pivot: inArray[" + r + "] = " + inArray[r]);
         if (myComp.compare(inArray[j],inArray[r]) == -1) {
            //System.out.println("Hello there!");
            temp = inArray[q];
            inArray[q] = inArray[j];
            inArray[j] = temp;
            q++;
            //System.out.println("In for loop: q is now " + q);
         }
      }
      //System.out.println("Doing final pivot swap. ");
      //System.out.println("Outside for loop: q is " + q);
      temp = inArray[r];
      inArray[r] = inArray[q];
      inArray[q] = temp;
      //System.out.println("q being returned = " + q);

      //System.out.println("Pivot = " + inArray[q]);

      return q;

   }

   public void iSort(T[] inArray) {
      qsort(inArray, 0, inArray.length-1);
      //System.out.println("Sorted array: ");
      /*for (int i=0;i<inArray.length;i++) {

         System.out.print(inArray[i] + " ");
      }*/

   }
   public T[] oSort(T[] inArray) {
      T[] arrayCopy = inArray;
      qsort(arrayCopy, 0, arrayCopy.length-1);
      return arrayCopy;
   }
   public long iSortTimed(T[] inArray) {
      return 0; // Placeholder
   }
   public void setComparator(Comparator<T> comparator) {
      myComp = comparator;
   }
}

public class sortNumbers {
   public static void main(String[] args) {
      boolean ascend = true;
      Random rand = new Random();
      long elapsedTime;
      int myArrLength = Integer.parseInt(args[0]);
      String mySortMethod = args[1];
      String sortDirection;
      Integer[] mySortedArray;
      if (args.length == 3) {
         //System.out.println("args.length of 3 detected ");
         sortDirection = args[2];
         if (sortDirection.equals("descend")) {
            ascend = false;
            //System.out.println("Ascend is now false");
         }
      }

      Integer[] myArray = new Integer[myArrLength];
      for (int i=0;i<myArrLength;i++) {
         myArray[i] = rand.nextInt(101);

      }
      switch(mySortMethod) {
         case "bubble":
         BubbleSort<Integer> myBub = new BubbleSort<Integer>();
         Comparator<Integer> myNewComp = new IntegerComparator(ascend);
         myBub.setComparator(myNewComp);
         myBub.iSort(myArray);
         mySortedArray = myBub.oSort(myArray);
         //System.out.println("Printing oSort array: ");
         if (myArray.length < 10) for (int i = 0; i<mySortedArray.length;i++) System.out.print(mySortedArray[i] + " ");
         elapsedTime = myBub.iSortTimed(myArray);
         System.out.println("\n" + elapsedTime);
         break;
         case "merge":
         MergeSort<Integer> myMg = new MergeSort<Integer>();
         Comparator<Integer> myMgComp = new IntegerComparator(ascend);
         myMg.setComparator(myMgComp);
         myMg.iSort(myArray);
         mySortedArray = myMg.oSort(myArray);
         //System.out.println("Printing oSort array: ");
         if (myArray.length < 10) for (int i = 0; i<mySortedArray.length;i++) System.out.print(mySortedArray[i] + " ");
         elapsedTime = myMg.iSortTimed(myArray);
         System.out.println("\n" + elapsedTime);
         break;
         case "quick":
         QuickSort<Integer> myQuick = new QuickSort<Integer>();
         Comparator<Integer> myQuickComp = new IntegerComparator(ascend);
         myQuick.setComparator(myQuickComp);
         if (myArray.length < 10) for (int i=0;i<myArray.length;i++) System.out.print(myArray[i] + " ");
         System.out.println();
         myQuick.iSort(myArray);
         mySortedArray = myQuick.oSort(myArray);
         if (myArray.length < 10) for (int i = 0; i<mySortedArray.length;i++) System.out.print(mySortedArray[i] + " ");
         //elapsedTime = myQuick.iSortTimed(myArray);
         //System.out.println("\n" + elapsedTime);
      }

      /*

      if (args.length <= 2) {
         int myArrLength = Integer.parseInt(args[0]);
         String mySortMethod = args[1];
         int[] myArray = new int[myArrLength];
      }
      else if (args.length <= 3) {
         int myArrLength = Integer.parseInt(args[0]);
         String mySortMethod = args[1];
         sortDirection = args[2];

         int[] myArray = new int[myArrLength];

         if (sortDirection == "ascend") {
            ascend = true;
         }
         else if (sortDirection == "descend") {
            ascend = false;
         }
      }*/


      //  Testing block
      /*BubbleSort<Integer> myBub = new BubbleSort<Integer>(); // Works
      //myBub.myComp = new IntegerComparator(ascend); // This works
      Comparator<Integer> myNewComp = new IntegerComparator(ascend); // Also works
      myBub.setComparator(myNewComp); // Works

      Integer[] myList = {5,3,2,4,1}; // Test list


      myBub.iSort(myList);*/

      /* Ignore float, other types for now
      Float[] myFloatList = {5.1f,3.2f,2.4f,4.1f,1.8f};
      System.out.println("Floatlist made");
      BubbleSort<Float> myFloatBub = new BubbleSort<Float>();
      System.out.println("FloatBub made");
      Comparator<Float> myFloatComp = new FloatComparator(ascend);
      System.out.println("floatComp made");
      System.out.println("Beginning sort");
      myFloatBub.iSort(myFloatList);
      */




      // use a for loop for args
   }

}

class IntegerComparator implements Comparator<Integer> {
   boolean ascend;

   public int compare(Integer a, Integer b) {
      if (ascend == true) {
         //System.out.println("Ascend is true");
         if (a < b) {
            return -1;
         }

         if (a > b) {
            return 1;
         }
         else return 0;

      }
      else {
         //System.out.println("Ascend is false");
         if (a < b) {
            return 1;
         }

         if (a > b) {
            return -1;
         }
         else return 0;
      }

   }

   public IntegerComparator(boolean ascend) {
      this.ascend = ascend;
   }

}

class FloatComparator implements Comparator<Float> {
   boolean ascend;

   public int compare(Float a, Float b) {
      int floatcomp = Float.compare(a,b);
      System.out.println("floatcomp = " + floatcomp);

      if (ascend == true) {
         //System.out.println("Ascend is true");
         if (floatcomp < 0) {
            return -1;
         }

         if (floatcomp > 0) {
            return 1;
         }
         else return 0;

      }
      else {
         //System.out.println("Ascend is false");
         if (floatcomp < 0) {
            return 1;
         }

         if (floatcomp > 0) {
            return -1;
         }
         else return 0;
      }

   }

   public FloatComparator(boolean ascend) {
      this.ascend = ascend;
   }

}
